package com.library.book.serviceImpl;

import com.library.book.Publisher;
import com.library.book.dto.PublisherDTO;
import com.library.book.mapper.PublisherMapper;
import com.library.book.repository.PublisherRepository;
import com.library.book.service.PublisherService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public List<PublisherDTO> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers.stream()
                .map(publisherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PublisherDTO getPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with id " + id));
        return publisherMapper.toDTO(publisher);
    }

    @Override
    public PublisherDTO savePublisher(PublisherDTO publisherDTO) {
        Publisher publisher = publisherMapper.toEntity(publisherDTO);
        Publisher savedPublisher = publisherRepository.save(publisher);
        return publisherMapper.toDTO(savedPublisher);
    }

    @Override
    public void deletePublisher(Long id) {
        if (!publisherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Publisher not found with id " + id);
        }
        publisherRepository.deleteById(id);
    }

    @Override
    public List<PublisherDTO> findPublishersByName(String name) {
        List<Publisher> publishers = publisherRepository.findByNameContaining(name);
        return publishers.stream()
                .map(publisherMapper::toDTO)
                .collect(Collectors.toList());
    }
}

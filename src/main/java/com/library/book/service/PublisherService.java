package com.library.book.service;

import com.library.book.dto.PublisherDTO;

import java.util.List;

public interface PublisherService {
    List<PublisherDTO> getAllPublishers();
    PublisherDTO getPublisherById(Long id);
    PublisherDTO savePublisher(PublisherDTO publisherDTO);
    void deletePublisher(Long id);
    List<PublisherDTO> findPublishersByName(String name);
}

package com.library.fine.serviceImpl;
import com.library.fine.FineItem;
import com.library.fine.dto.FineItemDTO;
import com.library.fine.mapper.FineItemMapper;
import com.library.fine.repository.FineItemRepository;
import com.library.fine.service.FineItemService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FineItemServiceImpl implements FineItemService {

    @Autowired
    private FineItemRepository fineItemRepository;

    @Autowired
    private FineItemMapper fineItemMapper;

    @Override
    public List<FineItemDTO> getAllFineItems() {
        List<FineItem> fineItems = fineItemRepository.findAll();
        return fineItems.stream()
                .map(fineItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FineItemDTO getFineItemById(Long id) {
        FineItem fineItem = fineItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fine item not found with id " + id));
        return fineItemMapper.toDTO(fineItem);
    }

    @Override
    public FineItemDTO saveFineItem(FineItemDTO fineItemDTO) {
        FineItem fineItem = fineItemMapper.toEntity(fineItemDTO);
        FineItem savedFineItem = fineItemRepository.save(fineItem);
        return fineItemMapper.toDTO(savedFineItem);
    }

    @Override
    public void deleteFineItem(Long id) {
        if (!fineItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("Fine item not found with id " + id);
        }
        fineItemRepository.deleteById(id);
    }

    @Override
    public List<FineItemDTO> findFineItemsByFineId(Long fineId) {
        List<FineItem> fineItems = fineItemRepository.findByFineId(fineId);
        return fineItems.stream()
                .map(fineItemMapper::toDTO)
                .collect(Collectors.toList());
    }
}

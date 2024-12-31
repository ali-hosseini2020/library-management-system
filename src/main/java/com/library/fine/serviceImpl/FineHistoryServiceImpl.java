package com.library.fine.serviceImpl;
import com.library.fine.FineHistory;
import com.library.fine.dto.FineHistoryDTO;
import com.library.fine.mapper.FineHistoryMapper;
import com.library.fine.repository.FineHistoryRepository;
import com.library.fine.service.FineHistoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FineHistoryServiceImpl implements FineHistoryService {

    @Autowired
    private FineHistoryRepository fineHistoryRepository;

    @Autowired
    private FineHistoryMapper fineHistoryMapper;

    @Override
    public List<FineHistoryDTO> getAllFineHistories() {
        List<FineHistory> fineHistories = fineHistoryRepository.findAll();
        return fineHistories.stream()
                .map(fineHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FineHistoryDTO getFineHistoryById(Long id) {
        FineHistory fineHistory = fineHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fine history not found with id " + id));
        return fineHistoryMapper.toDTO(fineHistory);
    }

    @Override
    public FineHistoryDTO saveFineHistory(FineHistoryDTO fineHistoryDTO) {
        FineHistory fineHistory = fineHistoryMapper.toEntity(fineHistoryDTO);
        FineHistory savedFineHistory = fineHistoryRepository.save(fineHistory);
        return fineHistoryMapper.toDTO(savedFineHistory);
    }

    @Override
    public void deleteFineHistory(Long id) {
        if (!fineHistoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Fine history not found with id " + id);
        }
        fineHistoryRepository.deleteById(id);
    }

    @Override
    public List<FineHistoryDTO> findFineHistoriesByFineId(Long fineId) {
        List<FineHistory> fineHistories = fineHistoryRepository.findByFineId(fineId);
        return fineHistories.stream()
                .map(fineHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}

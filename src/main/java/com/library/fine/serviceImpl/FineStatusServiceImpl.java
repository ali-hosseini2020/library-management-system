package com.library.fine.serviceImpl;
import com.library.fine.FineStatus;
import com.library.fine.dto.FineStatusDTO;
import com.library.fine.mapper.FineStatusMapper;
import com.library.fine.repository.FineStatusRepository;
import com.library.fine.service.FineStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FineStatusServiceImpl implements FineStatusService {

    @Autowired
    private FineStatusRepository fineStatusRepository;

    @Autowired
    private FineStatusMapper fineStatusMapper;

    @Override
    public List<FineStatusDTO> getAllFineStatuses() {
        List<FineStatus> fineStatuses = fineStatusRepository.findAll();
        return fineStatuses.stream()
                .map(fineStatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FineStatusDTO getFineStatusById(Long id) {
        FineStatus fineStatus = fineStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fine status not found with id " + id));
        return fineStatusMapper.toDTO(fineStatus);
    }

    @Override
    public FineStatusDTO saveFineStatus(FineStatusDTO fineStatusDTO) {
        FineStatus fineStatus = fineStatusMapper.toEntity(fineStatusDTO);
        FineStatus savedFineStatus = fineStatusRepository.save(fineStatus);
        return fineStatusMapper.toDTO(savedFineStatus);
    }

    @Override
    public void deleteFineStatus(Long id) {
        if (!fineStatusRepository.existsById(id)) {
            throw new ResourceNotFoundException("Fine status not found with id " + id);
        }
        fineStatusRepository.deleteById(id);
    }

    @Override
    public List<FineStatusDTO> findFineStatusesByFineId(Long fineId) {
        List<FineStatus> fineStatuses = fineStatusRepository.findByFineId(fineId);
        return fineStatuses.stream()
                .map(fineStatusMapper::toDTO)
                .collect(Collectors.toList());
    }
}

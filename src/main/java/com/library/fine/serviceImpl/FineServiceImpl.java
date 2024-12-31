package com.library.fine.serviceImpl;
import com.library.fine.Fine;
import com.library.fine.dto.FineDTO;
import com.library.fine.mapper.FineMapper;
import com.library.fine.repository.FineRepository;
import com.library.fine.service.FineService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FineServiceImpl implements FineService {

    @Autowired
    private FineRepository fineRepository;

    @Autowired
    private FineMapper fineMapper;

    @Override
    public List<FineDTO> getAllFines() {
        List<Fine> fines = fineRepository.findAll();
        return fines.stream()
                .map(fineMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FineDTO getFineById(Long id) {
        Fine fine = fineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fine not found with id " + id));
        return fineMapper.toDTO(fine);
    }

    @Override
    public FineDTO saveFine(FineDTO fineDTO) {
        Fine fine = fineMapper.toEntity(fineDTO);
        Fine savedFine = fineRepository.save(fine);
        return fineMapper.toDTO(savedFine);
    }

    @Override
    public void deleteFine(Long id) {
        if (!fineRepository.existsById(id)) {
            throw new ResourceNotFoundException("Fine not found with id " + id);
        }
        fineRepository.deleteById(id);
    }

    @Override
    public List<FineDTO> findFinesByUserId(Long userId) {
        List<Fine> fines = fineRepository.findByUserId(userId);
        return fines.stream()
                .map(fineMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FineDTO> findFinesByStatus(String status) {
        List<Fine> fines = fineRepository.findByStatus(status);
        return fines.stream()
                .map(fineMapper::toDTO)
                .collect(Collectors.toList());
    }
}

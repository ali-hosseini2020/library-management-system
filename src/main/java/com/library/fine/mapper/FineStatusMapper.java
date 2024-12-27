package com.library.fine.mapper;
import com.library.fine.FineStatus;
import com.library.fine.dto.FineStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FineStatusMapper {
    FineStatusMapper INSTANCE = Mappers.getMapper(FineStatusMapper.class);

    @Mapping(source = "fine.id", target = "fineId")
    FineStatusDTO toDTO(FineStatus fineStatus);

    @Mapping(target = "fine", ignore = true) // Assume fine is set separately
    FineStatus toEntity(FineStatusDTO fineStatusDTO);
}

package com.library.fine.mapper;
import com.library.fine.FineHistory;
import com.library.fine.dto.FineHistoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FineHistoryMapper {
    FineHistoryMapper INSTANCE = Mappers.getMapper(FineHistoryMapper.class);

    @Mapping(source = "fine.id", target = "fineId")
    FineHistoryDTO toDTO(FineHistory fineHistory);

    @Mapping(target = "fine", ignore = true) // Assume fine is set separately
    FineHistory toEntity(FineHistoryDTO fineHistoryDTO);
}

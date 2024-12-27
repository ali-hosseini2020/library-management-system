package com.library.fine.mapper;
import com.library.fine.Fine;
import com.library.fine.dto.FineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FineMapper {
    FineMapper INSTANCE = Mappers.getMapper(FineMapper.class);

    @Mapping(source = "user", target = "user")
    @Mapping(source = "items", target = "items")
    @Mapping(source = "history", target = "history")
    FineDTO toDTO(Fine fine);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    @Mapping(target = "items", ignore = true) // Assume items are set separately
    @Mapping(target = "history", ignore = true) // Assume history is set separately
    Fine toEntity(FineDTO fineDTO);
}

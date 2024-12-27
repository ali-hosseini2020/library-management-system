package com.library.fine.mapper;
import com.library.fine.FineItem;
import com.library.fine.dto.FineItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FineItemMapper {
    FineItemMapper INSTANCE = Mappers.getMapper(FineItemMapper.class);

    @Mapping(source = "fine.id", target = "fineId")
    FineItemDTO toDTO(FineItem fineItem);

    @Mapping(target = "fine", ignore = true) // Assume fine is set separately
    FineItem toEntity(FineItemDTO fineItemDTO);
}

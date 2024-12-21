package com.library.library.mapper;
import com.library.library.LibraryEvent;
import com.library.library.dto.LibraryEventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LibraryEventMapper {
    LibraryEventMapper INSTANCE = Mappers.getMapper(LibraryEventMapper.class);

    @Mapping(source = "library.id", target = "libraryId")
    @Mapping(source = "branch.id", target = "branchId")
    LibraryEventDTO toDTO(LibraryEvent libraryEvent);

    @Mapping(target = "library", ignore = true) // Assume library is set separately
    @Mapping(target = "branch", ignore = true) // Assume branch is set separately
    LibraryEvent toEntity(LibraryEventDTO libraryEventDTO);
}

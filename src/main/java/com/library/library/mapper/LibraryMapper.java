package com.library.library.mapper;
import com.library.library.Library;
import com.library.library.dto.LibraryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LibraryMapper {
    LibraryMapper INSTANCE = Mappers.getMapper(LibraryMapper.class);

    @Mapping(source = "branches", target = "branches")
    @Mapping(source = "users", target = "users")
    @Mapping(source = "events", target = "events")
    LibraryDTO toDTO(Library library);

    @Mapping(target = "branches", ignore = true) // Assume branches are set separately
    @Mapping(target = "users", ignore = true) // Assume users are set separately
    @Mapping(target = "events", ignore = true) // Assume events are set separately
    Library toEntity(LibraryDTO libraryDTO);
}

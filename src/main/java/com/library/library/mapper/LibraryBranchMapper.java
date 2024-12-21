package com.library.library.mapper;
import com.library.library.LibraryBranch;
import com.library.library.dto.LibraryBranchDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LibraryBranchMapper {
    LibraryBranchMapper INSTANCE = Mappers.getMapper(LibraryBranchMapper.class);

    @Mapping(source = "library.id", target = "libraryId")
    @Mapping(source = "users", target = "users")
    @Mapping(source = "events", target = "events")
    LibraryBranchDTO toDTO(LibraryBranch libraryBranch);

    @Mapping(target = "library", ignore = true) // Assume library is set separately
    @Mapping(target = "users", ignore = true) // Assume users are set separately
    @Mapping(target = "events", ignore = true) // Assume events are set separately
    LibraryBranch toEntity(LibraryBranchDTO libraryBranchDTO);
}

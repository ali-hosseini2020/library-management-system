package com.library.library.mapper;
import com.library.library.LibraryUser;
import com.library.library.dto.LibraryUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LibraryUserMapper {
    LibraryUserMapper INSTANCE = Mappers.getMapper(LibraryUserMapper.class);

    @Mapping(source = "library.id", target = "libraryId")
    @Mapping(source = "branch.id", target = "branchId")
    @Mapping(source = "memberships", target = "memberships")
    LibraryUserDTO toDTO(LibraryUser libraryUser);

    @Mapping(target = "library", ignore = true) // Assume library is set separately
    @Mapping(target = "branch", ignore = true) // Assume branch is set separately
    @Mapping(target = "memberships", ignore = true) // Assume memberships are set separately
    LibraryUser toEntity(LibraryUserDTO libraryUserDTO);
}
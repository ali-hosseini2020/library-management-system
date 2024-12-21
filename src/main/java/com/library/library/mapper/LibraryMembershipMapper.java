package com.library.library.mapper;
import com.library.library.LibraryMembership;
import com.library.library.dto.LibraryMembershipDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface LibraryMembershipMapper {
    LibraryMembershipMapper INSTANCE = Mappers.getMapper(LibraryMembershipMapper.class);

    @Mapping(source = "user.id", target = "userId")
    LibraryMembershipDTO toDTO(LibraryMembership libraryMembership);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    LibraryMembership toEntity(LibraryMembershipDTO libraryMembershipDTO);
}
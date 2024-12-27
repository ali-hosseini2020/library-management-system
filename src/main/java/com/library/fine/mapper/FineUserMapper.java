package com.library.fine.mapper;
import com.library.fine.FineUser;
import com.library.fine.dto.FineUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FineUserMapper {
    FineUserMapper INSTANCE = Mappers.getMapper(FineUserMapper.class);

    @Mapping(source = "fines", target = "fines")
    FineUserDTO toDTO(FineUser fineUser);

    @Mapping(target = "fines", ignore = true) // Assume fines are set separately
    FineUser toEntity(FineUserDTO fineUserDTO);
}

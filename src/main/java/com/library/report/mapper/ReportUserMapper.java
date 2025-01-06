package com.library.report.mapper;
import com.library.report.ReportUser;
import com.library.report.dto.ReportUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportUserMapper {
    ReportUserMapper INSTANCE = Mappers.getMapper(ReportUserMapper.class);

    @Mapping(source = "reports", target = "reports")
    ReportUserDTO toDTO(ReportUser reportUser);

    @Mapping(target = "reports", ignore = true) // Assume reports are set separately
    ReportUser toEntity(ReportUserDTO reportUserDTO);
}

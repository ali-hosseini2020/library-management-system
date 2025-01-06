package com.library.report.mapper;
import com.library.report.ReportStatus;
import com.library.report.dto.ReportStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportStatusMapper {
    ReportStatusMapper INSTANCE = Mappers.getMapper(ReportStatusMapper.class);

    @Mapping(source = "report.id", target = "reportId")
    ReportStatusDTO toDTO(ReportStatus reportStatus);

    @Mapping(target = "report", ignore = true) // Assume report is set separately
    ReportStatus toEntity(ReportStatusDTO reportStatusDTO);
}

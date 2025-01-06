package com.library.report.mapper;
import com.library.report.Report;
import com.library.report.dto.ReportDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    @Mapping(source = "user", target = "user")
    @Mapping(source = "items", target = "items")
    @Mapping(source = "history", target = "history")
    ReportDTO toDTO(Report report);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    @Mapping(target = "items", ignore = true) // Assume items are set separately
    @Mapping(target = "history", ignore = true) // Assume history is set separately
    Report toEntity(ReportDTO reportDTO);
}

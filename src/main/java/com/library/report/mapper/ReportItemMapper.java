package com.library.report.mapper;
import com.library.report.ReportItem;
import com.library.report.dto.ReportItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportItemMapper {
    ReportItemMapper INSTANCE = Mappers.getMapper(ReportItemMapper.class);

    @Mapping(source = "report.id", target = "reportId")
    ReportItemDTO toDTO(ReportItem reportItem);

    @Mapping(target = "report", ignore = true) // Assume report is set separately
    ReportItem toEntity(ReportItemDTO reportItemDTO);
}

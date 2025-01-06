package com.library.report.mapper;
import com.library.report.ReportHistory;
import com.library.report.dto.ReportHistoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportHistoryMapper {
    ReportHistoryMapper INSTANCE = Mappers.getMapper(ReportHistoryMapper.class);

    @Mapping(source = "report.id", target = "reportId")
    ReportHistoryDTO toDTO(ReportHistory reportHistory);

    @Mapping(target = "report", ignore = true) // Assume report is set separately
    ReportHistory toEntity(ReportHistoryDTO reportHistoryDTO);
}

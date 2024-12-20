package com.library.book.mapper;
import com.library.book.BookSeries;
import com.library.book.dto.BookSeriesDTO;
import com.library.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookSeriesMapper {

    BookSeriesDTO toDTO(BookSeries bookSeries);

    BookSeries toEntity(BookSeriesDTO bookSeriesDTO);

    @Named("validateAndMap")
    default String validateAndMap(String input) {
        if (input == null || input.isEmpty()) {
            throw new BadRequestException("Input cannot be null or empty");
        }
        return input;
    }
}

package com.library.book.mapper;

import com.library.book.BookLocation;
import com.library.book.dto.BookLocationDTO;
import com.library.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookLocationMapper {

    BookLocationDTO toDTO(BookLocation bookLocation);

    BookLocation toEntity(BookLocationDTO bookLocationDTO);

    @Named("validateAndMap")
    default String validateAndMap(String input) {
        if (input == null || input.isEmpty()) {
            throw new BadRequestException("Input cannot be null or empty");
        }
        return input;
    }
}

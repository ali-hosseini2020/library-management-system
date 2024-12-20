package com.library.book.mapper;

import com.library.book.BookTag;
import com.library.book.dto.BookTagDTO;
import com.library.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookTagMapper {

    BookTagDTO toDTO(BookTag bookTag);

    BookTag toEntity(BookTagDTO bookTagDTO);

    @Named("validateAndMap")
    default String validateAndMap(String input) {
        if (input == null || input.isEmpty()) {
            throw new BadRequestException("Input cannot be null or empty");
        }
        return input;
    }
}

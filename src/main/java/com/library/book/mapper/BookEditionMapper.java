package com.library.book.mapper;

import com.library.book.BookEdition;
import com.library.book.dto.BookEditionDTO;
import com.library.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookEditionMapper {

    BookEditionDTO toDTO(BookEdition bookEdition);

    BookEdition toEntity(BookEditionDTO bookEditionDTO);

    @Named("validateAndMap")
    default String validateAndMap(String input) {
        if (input == null || input.isEmpty()) {
            throw new BadRequestException("Input cannot be null or empty");
        }
        return input;
    }
}

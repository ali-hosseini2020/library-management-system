package com.library.book.mapper;

import com.library.book.Author;
import com.library.book.dto.AuthorDTO;
import com.library.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO toDTO(Author author);

    Author toEntity(AuthorDTO authorDTO);

    @Named("validateAndMap")
    default String validateAndMap(String input) {
        if (input == null || input.isEmpty()) {
            throw new BadRequestException("Input cannot be null or empty");
        }
        return input;
    }
}

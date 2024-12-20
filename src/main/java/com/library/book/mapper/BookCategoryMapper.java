package com.library.book.mapper;

import com.library.book.BookCategory;
import com.library.book.dto.BookCategoryDTO;
import com.library.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookCategoryMapper {

    BookCategoryDTO toDTO(BookCategory bookCategory);

    BookCategory toEntity(BookCategoryDTO bookCategoryDTO);

    @Named("validateAndMap")
    default String validateAndMap(String input) {
        if (input == null || input.isEmpty()) {
            throw new BadRequestException("Input cannot be null or empty");
        }
        return input;
    }
}

package com.library.book.mapper;

import com.library.book.BookReview;
import com.library.book.dto.BookReviewDTO;
import com.library.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookReviewMapper {

    BookReviewDTO toDTO(BookReview bookReview);

    BookReview toEntity(BookReviewDTO bookReviewDTO);

    @Named("validateAndMap")
    default String validateAndMap(String input) {
        if (input == null || input.isEmpty()) {
            throw new BadRequestException("Input cannot be null or empty");
        }
        return input;
    }
}

package com.library.book.mapper;

import com.library.book.Book;
import com.library.book.dto.BookDTO;
import com.library.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "author.name", target = "authorName")
    @Mapping(source = "publisher.name", target = "publisherName")
    @Mapping(source = "category.name", target = "categoryName")
    BookDTO toDTO(Book book);

    @Mapping(target = "author", ignore = true) // Assume author is set separately
    @Mapping(target = "publisher", ignore = true) // Publisher is set separately
    @Mapping(target = "category", ignore = true) // Category is set separately
    Book toEntity(BookDTO bookDTO);

    @Named("validateAndMap")
    default String validateAndMap(String input) {
        if (input == null || input.isEmpty()) {
            throw new BadRequestException("Input cannot be null or empty");
        }
        return input;
    }
}

package com.shirajussalekin.lms.mappers;

import com.shirajussalekin.lms.dto.BookDto;
import com.shirajussalekin.lms.entities.Book;

public class BookMapper {
    public static BookDto mapToBookDto(Book book){
        return new BookDto(
                book.getId(),
                book.getName(),
                book.getDescription(),
                book.getBookPrice(),
                book.getBookImgUrl(),
                book.getPublicationName(),
                book.getPublicationDate(),
                book.getPublicationDate(),
                book.getReaders(),
                book.getAuthors()
        );
    }

    public static Book mapToBook(BookDto bookDto){
        return new Book(
                bookDto.getId(),
                bookDto.getName(),
                bookDto.getDescription(),
                bookDto.getBookPrice(),
                bookDto.getBookImgUrl(),
                bookDto.getPublicationName(),
                bookDto.getPublicationDate(),
                bookDto.getCreationDateTime(),
                bookDto.getReaders(),
                bookDto.getAuthors()
        );
    }

}

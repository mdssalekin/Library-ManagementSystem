package com.shirajussalekin.lms.services;

import com.shirajussalekin.lms.dto.BookDto;
import com.shirajussalekin.lms.entities.Book;

import java.util.List;

public interface BookService {

    BookDto createBook(BookDto bookDto);

    BookDto getBookById(Long id);

    List<BookDto> getAllBooks();

    BookDto updateBook(Long id, BookDto bookDto);

    void deleteBook(Long id);



}

package com.shirajussalekin.lms.services.impl;

import com.shirajussalekin.lms.dao.BookRepository;
import com.shirajussalekin.lms.dto.BookDto;
import com.shirajussalekin.lms.entities.Book;
import com.shirajussalekin.lms.entities.Employee;
import com.shirajussalekin.lms.exceptions.ResourceNotFoundException;
import com.shirajussalekin.lms.mappers.BookMapper;
import com.shirajussalekin.lms.mappers.EmployeeMapper;
import com.shirajussalekin.lms.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = BookMapper.mapToBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return BookMapper.mapToBookDto(savedBook);
    }

    @Override
    public BookDto getBookById(Long id) {
        return BookMapper
                .mapToBookDto(bookRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("The Book does not exist by given ID!!")));
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(
                        (book) -> BookMapper.mapToBookDto(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        if (!bookRepository.existsById(id))
            throw new ResourceNotFoundException("The Book does not exist by given ID!!");

        Book newBook = new Book(
                bookDto.getId(),
                bookDto.getName(),
                bookDto.getDescription(),
                bookDto.getBookPrice(),
                bookDto.getBookImgUrl(),
                bookDto.getPublicationName(),
                bookDto.getPublicationDate(),
                bookDto.getCreationDateTime(),
                bookDto.getReaders()
        );
        return BookMapper.mapToBookDto(bookRepository.save(newBook));
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id))
            throw new ResourceNotFoundException("The Book does not exist by given ID!!");
        bookRepository.deleteById(id);
    }
}

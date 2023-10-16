package com.shirajussalekin.lms.controllers;

import com.shirajussalekin.lms.dto.BookDto;
import com.shirajussalekin.lms.dto.EmployeeDto;
import com.shirajussalekin.lms.services.AuthorService;
import com.shirajussalekin.lms.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        BookDto book = bookService.createBook(bookDto);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PutMapping("{id}")
    public ResponseEntity<BookDto> updateBook(
            @PathVariable("id") long bookId,
            @RequestBody BookDto updatedBook){
        return ResponseEntity.ok(bookService.updateBook(bookId, updatedBook));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(
            @PathVariable("id") Long bookId
    ) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok("The Book has been deleted successfully!");
    }
}

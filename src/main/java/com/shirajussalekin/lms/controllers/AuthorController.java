package com.shirajussalekin.lms.controllers;

import com.shirajussalekin.lms.dto.AuthorDto;
import com.shirajussalekin.lms.exceptions.ResourceNotFoundException;
import com.shirajussalekin.lms.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        if (authorService.existsById(authorDto.getId()))
            throw new ResourceNotFoundException("The Author exists!");
        return new ResponseEntity<>(authorService.createAuthor(authorDto), HttpStatus.CREATED);
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable("id") Long authorId) {
        return ResponseEntity.ok(authorService.getAuthorById(authorId));
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(
            @PathVariable("id") long authorId,
            @RequestBody AuthorDto updatedAuthor){
        return ResponseEntity.ok(authorService.updateAuthor(authorId, updatedAuthor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAuthor(
            @PathVariable("id") Long authorId
    ) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok("The Author has been deleted successfully!");
    }

    @GetMapping("/search/email/{emailId}")
    public ResponseEntity<AuthorDto> findAuthorByEmail(
            @PathVariable("emailId") String emailId
    ){
        return ResponseEntity.ok(authorService.findAuthorByEmail(emailId));
    }

//    @GetMapping("/search/date/{queryYear}")
//    public ResponseEntity<List<AuthorDto>> findAllAuthorsByCreationDateTime(
//            @PathVariable("queryYear") int queryYear
//    ){
//        return ResponseEntity.ok(authorService.findAllAuthorByJoiningYear(queryYear));
//    }
}

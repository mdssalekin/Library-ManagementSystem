package com.shirajussalekin.lms.services;

import com.shirajussalekin.lms.dto.AuthorDto;
import com.shirajussalekin.lms.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorService {

    AuthorDto createAuthor(AuthorDto authorDto);
    AuthorDto getAuthorById(Long id);
    List<AuthorDto> getAllAuthors();

    AuthorDto updateAuthor(Long id, AuthorDto authorDto);

    void deleteAuthor(Long id);
}

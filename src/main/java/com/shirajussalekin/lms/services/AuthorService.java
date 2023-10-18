package com.shirajussalekin.lms.services;

import com.shirajussalekin.lms.dto.AuthorDto;

import java.util.List;


public interface AuthorService {

    AuthorDto createAuthor(AuthorDto authorDto);
    AuthorDto getAuthorById(Long id);
    List<AuthorDto> getAllAuthors();

    AuthorDto updateAuthor(Long id, AuthorDto authorDto);

    void deleteAuthor(Long id);

    boolean existsById(Long id);

    AuthorDto findAuthorByEmail(String email);

    //List<AuthorDto> findAllAuthorByJoiningYear(int queryYear);


}

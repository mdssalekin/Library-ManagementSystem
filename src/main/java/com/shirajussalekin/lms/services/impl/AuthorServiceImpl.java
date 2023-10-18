package com.shirajussalekin.lms.services.impl;

import com.shirajussalekin.lms.dao.AuthorRepository;
import com.shirajussalekin.lms.dto.AuthorDto;
import com.shirajussalekin.lms.entities.Author;
import com.shirajussalekin.lms.exceptions.ResourceNotFoundException;
import com.shirajussalekin.lms.mappers.AuthorMapper;
import com.shirajussalekin.lms.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        return AuthorMapper
                .mapToAuthorDto(authorRepository
                        .save(AuthorMapper
                                .mapToAuthor(authorDto)));
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        return AuthorMapper
                .mapToAuthorDto(authorRepository.findById(id)
                        .orElseThrow( () -> new ResourceNotFoundException("The Author does not exist by given ID!!")));
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository
                .findAll()
                .stream()
                .map(AuthorMapper::mapToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto updateAuthor(Long id, AuthorDto authorDto) {
        if (!authorRepository.existsById(id))
            throw new ResourceNotFoundException("The Author does not exist by given ID!!");

        Author author = new Author (
                authorDto.getId(),
                authorDto.getFirstName(),
                authorDto.getLastName(),
                authorDto.getEmail(),
                authorDto.getGender(),
                authorDto.getContactNo(),
                authorDto.getImgUrl(),
                authorDto.getDateOfBirth(),
                authorDto.getCreationDateTime(),
                authorDto.getBooks()
        );
        return AuthorMapper.mapToAuthorDto(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id))
            throw new ResourceNotFoundException("The Author does not exist by given ID!!");
        authorRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id){
        return authorRepository.existsById(id);
    }

    @Override
    public AuthorDto findAuthorByEmail(String email) {
        return AuthorMapper.mapToAuthorDto(authorRepository.findAuthorByEmail(email));
    }

//    @Override
//    public List<AuthorDto> findAllAuthorByJoiningYear(int queryYear){
//        return authorRepository
//                .findAllAuthorByCreationDateTime(queryYear)
//                .stream()
//                .map(AuthorMapper::mapToAuthorDto)
//                .collect(Collectors.toList());
//    }
}

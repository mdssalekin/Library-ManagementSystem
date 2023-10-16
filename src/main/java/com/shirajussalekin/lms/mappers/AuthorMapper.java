package com.shirajussalekin.lms.mappers;

import com.shirajussalekin.lms.dto.AuthorDto;
import com.shirajussalekin.lms.entities.Author;

public class AuthorMapper {
    public static AuthorDto mapToAuthorDto(Author author){
        return new AuthorDto(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getEmail(),
                author.getGender(),
                author.getContactNo(),
                author.getImgUrl(),
                author.getDateOfBirth(),
                author.getCreationDateTime(),
                author.getBooks()
        );
    }

    public static Author mapToAuthor(AuthorDto authorDto){
        return new Author(
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
    }
}

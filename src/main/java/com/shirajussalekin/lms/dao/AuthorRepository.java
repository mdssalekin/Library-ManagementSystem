package com.shirajussalekin.lms.dao;

import com.shirajussalekin.lms.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

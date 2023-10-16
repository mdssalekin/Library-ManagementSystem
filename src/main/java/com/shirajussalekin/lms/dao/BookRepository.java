package com.shirajussalekin.lms.dao;

import com.shirajussalekin.lms.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

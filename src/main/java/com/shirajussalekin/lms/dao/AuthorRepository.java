package com.shirajussalekin.lms.dao;

import com.shirajussalekin.lms.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    //@Query("select a from Author a where a.email =: emailId")
    Author findAuthorByEmail(String emailId);

    //@Query("select a from Author a where year(a.creationDateTime) =: queryYear")
    @Query(name = "SELECT * FROM Authors WHERE YEAR(creation_time) =: queryYear", nativeQuery = true)
    List<Author> findAllAuthorByCreationDateTime(@Param("queryYear") int queryYear);

}

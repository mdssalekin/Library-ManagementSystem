package com.shirajussalekin.lms.Specifications;

import com.shirajussalekin.lms.entities.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.util.Date;

public class AuthorSpecifications {

    public static Specification<Author> findAuthorById(Long id){
        return (root, query, cb) -> cb.equal(root.get("id"), id);
    }

    public static Specification<Author> findAuthorByEmail(String email){
        return (root, query, cb) -> cb.like(root.get("email"), "%" + email + "%");
    }

    public static Specification<Author> findAuthorByCreationDateTime(Date creationDateTime){
        return ((root, query, cb) -> cb.equal(root.get("creationDateTime"), creationDateTime));
    }
}

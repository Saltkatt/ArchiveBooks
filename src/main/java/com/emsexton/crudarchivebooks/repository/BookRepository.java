package com.emsexton.crudarchivebooks.repository;

import com.emsexton.crudarchivebooks.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByYear(String year);

    List<Book> findByLanguage(String language);
}

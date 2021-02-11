package com.emsexton.crudarchivebooks.repository;

import com.emsexton.crudarchivebooks.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

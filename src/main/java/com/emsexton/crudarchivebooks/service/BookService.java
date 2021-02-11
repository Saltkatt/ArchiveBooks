package com.emsexton.crudarchivebooks.service;

import com.emsexton.crudarchivebooks.entity.Book;
import com.emsexton.crudarchivebooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAllBooks(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(bookOne -> books.add(bookOne));
        return books;
    }





}

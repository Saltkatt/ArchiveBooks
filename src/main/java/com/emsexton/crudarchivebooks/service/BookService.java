package com.emsexton.crudarchivebooks.service;

import com.emsexton.crudarchivebooks.entity.Book;
import com.emsexton.crudarchivebooks.exception.ResourceNotFoundException;
import com.emsexton.crudarchivebooks.model.BookModel;
import com.emsexton.crudarchivebooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    private Book book;

    public void save(Book book){
        bookRepository.save(book);
    }

    public List<Book> findAllBooks(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(bookOne -> books.add(bookOne));
        return books;
    }

    public Book findBookById(Long id) throws ResourceNotFoundException {
        book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));

        return book;

    }


    public Map<String, Boolean> delete(Long id) throws ResourceNotFoundException {
        book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));

        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

   /* public List findBookByAuthor(String author) throws ResourceNotFoundException {

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        List<Book> books = bookRepository.findByAuthor(author);
        System.out.println(books);

        return books;
    }*/

    public List findBookByAuthor(String author) {

        List book = bookRepository.findByAuthor(author);
        System.out.println(book);

        return book;
    }

    public List findBookByYear(String year) {
        List book = bookRepository.findByYear(year);
        System.out.println(book);
        return book;
    }
}

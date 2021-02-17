package com.emsexton.crudarchivebooks.controller;

import com.emsexton.crudarchivebooks.entity.Book;
import com.emsexton.crudarchivebooks.exception.ResourceNotFoundException;
import com.emsexton.crudarchivebooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/archive")
public class BookController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BookService bookService;

    String msg = "Information regarding CRUD services";

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }

   /* @GetMapping("/books/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable(value = "id") Long id){
        try{
            Book book = bookService.findBookById(id);

            return ResponseEntity.ok().body(book);
        }catch(Exception e){
            e.printStackTrace();
            log.error("Error: Unable to delete book by id: " + id);
            return ResponseEntity.notFound().build();
        }

    }*/

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable(value = "id") Long id){
        try{
            Book book = bookService.findBookById(id);
            return ResponseEntity.ok().body(book);

        }catch(Exception e){
            e.printStackTrace();
            log.error("Error: Unable to find book by id: " + id);
            return ResponseEntity.notFound().build();
        }
    }
    //requestparam should be used for frontend
   /* @GetMapping("/books/")
    public String findBookByAuthor(@RequestParam(value = "author") String author){
        try{
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            List book = bookService.findBookByAuthor(author);
            System.out.println(book);
            msg = book.toString();
            System.out.println("£££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££££");
            return msg;
        }catch (Exception e){
            e.printStackTrace();
            msg = "Error: Unable to find book by author: " + author;
            log.error("Error: Unable to find book by author: " + author);
            return msg;
        }
    }*/

    @GetMapping("/books/")
    public ResponseEntity<List> findBookByAuthor(@RequestParam(value = "author") String author){
        try{
            List book = bookService.findBookByAuthor(author);
            return ResponseEntity.ok().body(book);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Error: Unable to find book by author: " + author);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/books")
    public String createBook(@RequestBody Book book){
        try{
            msg = "Book has been added to archive" + "\r\n" + book.toString();
            bookService.save(book);
            //System.out.println(book);
            return msg;

        }catch(Exception e) {
            e.printStackTrace();
            msg = "Error: Unable to add new book";
            log.error("Unable to add new book");
            return msg;
        }
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        try{
            msg = "Book deleted";
            bookService.delete(id);
            return msg;
        }
        catch (Exception e){
            e.printStackTrace();
            msg = "Error: Unable to delete book by id: " + id;
            log.error("Unable to delete book by id: " + id);
            return msg;
        }
    }


}

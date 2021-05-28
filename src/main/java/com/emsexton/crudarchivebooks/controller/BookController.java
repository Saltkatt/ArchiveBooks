package com.emsexton.crudarchivebooks.controller;

import com.emsexton.crudarchivebooks.util.RabbitMQSend;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.emsexton.crudarchivebooks.entity.Book;
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

    @CrossOrigin(origins = "*")
    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable(value = "id") Long id){
        try{
            Book book = bookService.findBookById(id);
            log.error("Book found by id: " + id);
            return ResponseEntity.ok().body(book);

        }catch(Exception e){
            e.printStackTrace();
            log.error("Error: Unable to find book by id: " + id);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/books/")
    public ResponseEntity<List> findBookByAuthor(@RequestParam(value = "author") String author){
        try{
            List book = bookService.findBookByAuthor(author);
            log.error("Book by author: " + author + "has been found");
            return ResponseEntity.ok().body(book);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Error: Unable to find book by author: " + author);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/books/year/")
    public ResponseEntity<List> findBookByYear(@RequestParam(value = "year") String year){
        try{
            List book = bookService.findBookByYear(year);
            log.error("Book by year: " + year + "has been found");
            return ResponseEntity.ok().body(book);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Error: Unable to find book by year: " + year);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/books/language")
    public ResponseEntity<List> findBookByLanguage(@RequestParam(value = "language") String language){
        try{
            List book = bookService.findBookByLanguage(language);
            log.error("Book by language: " + language + "has been found");
            return ResponseEntity.ok().body(book);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Error: Unable to find book by language: " + language);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        try{
            msg = "Book has been added to archive" + "\r\n" + book.toString();
            bookService.save(book);
            //System.out.println(book);
            log.error("Book has been added.");
            RabbitMQSend.bookAdded(book);
            return ResponseEntity.ok().body(book);

        }catch(Exception e) {
            e.printStackTrace();
            //msg = "Error: Unable to add new book";
            log.error("Unable to add new book");
            return ResponseEntity.badRequest().build();
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long id){
        try{
            msg = "Book deleted";

            bookService.delete(id);
            log.error("Book id: " + id + " has been deleted");
            RabbitMQSend.bookDeleted(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            e.printStackTrace();
            //msg = "Error: Unable to delete book by id: " + id;
            log.error("Unable to delete book by id: " + id);
            return ResponseEntity.notFound().build();
        }
    }


}

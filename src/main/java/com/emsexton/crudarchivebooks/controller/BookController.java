package com.emsexton.crudarchivebooks.controller;

import com.emsexton.crudarchivebooks.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/archive")
public class BookController {

    private BookService bookService;


}

package com.emsexton.crudarchivebooks.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookModel {

    private String title;
    private String author;
    private String description;
    private int rating;
    private Date published;


}

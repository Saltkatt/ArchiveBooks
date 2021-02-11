package com.emsexton.crudarchivebooks.entity;

import com.emsexton.crudarchivebooks.model.BookModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="archive-books")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bookId")
    private Long id;

    @Column(name="bookTitle", nullable = false, unique = false)
    private String title;

    @Column(name="bookAuthor", nullable = false)
    private String author;

    @Column(name="bookDescription")
    private String description;

    @Column(name="bookRating")
    private int rating;

    @Temporal(TemporalType.DATE)
    @Column(name="bookPublished")
    private Date published;


    public BookModel toModel(){
        BookModel bookModel = new BookModel();

        bookModel.setTitle(getTitle());
        bookModel.setAuthor(getAuthor());
        bookModel.setDescription(getDescription());
        bookModel.setPublished(getPublished());
        bookModel.setRating(getRating());

        return bookModel;
    }

    public String toString(){
        return "Title: " + title
                + "\r\nAuthor: " + author
                + "\r\nDescription: " + description
                + "\r\nPublished: " + published
                + "\r\nRating: " + rating;
    }
}

package com.emsexton.crudarchivebooks.entity;

import com.emsexton.crudarchivebooks.model.BookModel;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="book")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = -7055707354641685721L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BookId")
    private Long id;

    @Column(name="BookTitle", nullable = false)
    private String title;

    @Column(name="BookAuthor", nullable = false)
    private String author;

    @Column(name="BookDescription")
    private String description;

    @Column(name="BookRating")
    private int rating;

    @Column(name="BookPublished")
    private String published;

    @Column(name="BookLanguage")
    private String language;

    @Column(name="BookGenre")
    private String genre;



    public BookModel toModel(){
        BookModel bookModel = new BookModel();

        bookModel.setTitle(getTitle());
        bookModel.setAuthor(getAuthor());
        bookModel.setDescription(getDescription());
        bookModel.setPublished(getPublished());
        bookModel.setRating(getRating());
        bookModel.setGenre(getGenre());
        bookModel.setLanguage(getLanguage());


        return bookModel;
    }

    @Override
    public String toString(){
        return "\r\nId: " + id
                + "\r\nTitle: " + title
                + "\r\nAuthor: " + author
                + "\r\nDescription: " + description
                + "\r\nPublished: " + published
                + "\r\nLanguage: " + language
                + "\r\nGenre: " + genre
                + "\r\nRating: " + rating + "\r\n";
    }
}

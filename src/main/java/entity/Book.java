package entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="archive-books")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book {

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




}

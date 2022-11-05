package com.oxksusu.back.api.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "BOOK_TITLE")
    public String bookTitle;

    @Column(name = "AUTHOR")
    public String author;

    @Column(name = "CATEGORY")
    public String category;

    @Column(name = "BOOK_THUMBNAIL", length = 1000)
    public String bookThumbnail;

}

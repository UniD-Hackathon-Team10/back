package com.oxksusu.back.api.repository;

import com.oxksusu.back.api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByBookTitle(String bookTitle);
}

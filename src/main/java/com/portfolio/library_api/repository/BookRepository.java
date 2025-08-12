package com.portfolio.library_api.repository;

import com.portfolio.library_api.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(Long id){
        return books.stream()
            .filter(book -> book.getId().equals(id))
            .findFirst();
    }

    public Book save(Book book){
        if (book.getId() == null){
            book.setId(nextId++);
            books.add(book);
        }else {
            books.replaceAll(b -> b.getId().equals(book.getId()) ? book : b);
        }
        return book;
    }

    public void deleteById(Long id){
        books.removeIf(book -> book.getId().equals(id));
    }
}

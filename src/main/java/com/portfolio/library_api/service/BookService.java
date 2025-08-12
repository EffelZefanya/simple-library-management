package com.portfolio.library_api.service;

import org.springframework.stereotype.Service;

import com.portfolio.library_api.model.Book;
import com.portfolio.library_api.repository.BookRepository;

import java.util.*;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository){
        this.repository = repository;
    }

    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return repository.findById(id);
    }

    public Book addBook(Book book){
        return repository.save(book);
    }

    public void deleteBook(Long id){
        repository.deleteById(id);
    }
}

package com.portfolio.library_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.library_api.dto.BookDTO;
import com.portfolio.library_api.service.BookService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping
    public List<BookDTO> getAllBooks () {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        return service.getBookById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public BookDTO addBook(@Valid @RequestBody BookDTO bookDTO){
        return service.addBook(bookDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

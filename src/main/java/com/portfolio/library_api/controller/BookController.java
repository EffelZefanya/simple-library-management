package com.portfolio.library_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.library_api.dto.BookDTO;
import com.portfolio.library_api.service.BookService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



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

    @PatchMapping("/{id}/borrow")
    public ResponseEntity<BookDTO> borrowBook(@PathVariable Long id){
        return service.borrowBook(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/return")
    public ResponseEntity<BookDTO> putMethodName(@PathVariable Long id) {
        return service.returnBook(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}

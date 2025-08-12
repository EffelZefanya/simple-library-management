package com.portfolio.library_api.service;

import org.springframework.stereotype.Service;

import com.portfolio.library_api.dto.BookDTO;
import com.portfolio.library_api.model.Book;
import com.portfolio.library_api.repository.BookRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository repository;

    private BookDTO toBookDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setQuantity(book.getQuantity());
        return dto;
    }

    private Book toBook(BookDTO bookDTO){
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setQuantity(bookDTO.getQuantity());
        return book;
    }

    public BookService(BookRepository repository){
        this.repository = repository;
    }

    public List<BookDTO> getAllBooks(){
        return repository.findAll().stream()
                .map(this::toBookDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookDTO> getBookById(Long id){
        return repository.findById(id)
            .map(this::toBookDTO);
    }

    public BookDTO addBook(BookDTO bookDTO){
        Book book = toBook(bookDTO);
        return toBookDTO(repository.save(book));
    }

    public void deleteBook(Long id){
        repository.deleteById(id);
    }
}

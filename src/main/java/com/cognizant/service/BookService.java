package com.cognizant.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Book;
import com.cognizant.repo.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    };

    public Book createBook(Book book) throws Exception {
        Book existingBook = bookRepository.findByTitle(book.getTitle());
        if (existingBook != null)
            throw new Exception("Book already exists!");
        else {
            Book newBook = bookRepository.save(book);
            return newBook;
        }
    }
}

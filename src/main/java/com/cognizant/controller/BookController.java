package com.cognizant.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.BookService;
import com.cognizant.service.UserService;
import com.cognizant.entity.Book;
import com.cognizant.entity.User;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/")
    public Book createBook(@RequestBody Book req, @RequestHeader Map<String, String> header) throws Exception {
        String username = header.get("username");
        if (username == null)
            throw new Exception("Username not provided!");
        else {
            User existingUser = userService.getUser(username);
            System.out.println(existingUser.toString());
            if (existingUser == null || !existingUser.getRole().equals("admin"))
                throw new Exception("Access not authorized!");
            else {
                Book book = new Book();
                book.setTitle(req.getTitle());
                book.setDescription(req.getDescription());
                book.setAuthor(req.getAuthor());
                book.setPublishYear(req.getPublishYear());

                Book newBook = bookService.createBook(book);
                System.out.println(newBook.toString());
                return newBook;
            }
        }
    }
}

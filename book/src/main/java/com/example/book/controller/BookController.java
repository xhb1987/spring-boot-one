package com.example.book.controller;

import java.security.Principal;
import java.util.List;

import com.example.book.modal.Book;
import com.example.book.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> findAllBooks() {       
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        Boolean isAuth = auth.isAuthenticated();
        System.out.println(isAuth);
        return bookService.findAllBooks();
    }
}
package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.modal.Book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BookService {
    public List<Book> findAllBooks() {
        Book exampleBook = new Book();
        List<Book> books = new ArrayList<Book>();

        exampleBook.setTitle("test title");
        exampleBook.setAuthor("test author");
        exampleBook.setId(1234);

        books.add(exampleBook);
        return books;
    }
}
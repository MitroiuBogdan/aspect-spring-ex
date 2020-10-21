package com.example.course2.service;

import com.example.course2.aspect.Transaction;
import com.example.course2.model.Book;
import com.example.course2.repositories.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookManagementService {

    private final BookRepository bookRepository;

    public BookManagementService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transaction
    public void addBook(Book book) {

        if (book.getTitle().equals("Hero")) {
            throw new RuntimeException();
        } else {
            bookRepository.addBook(book);
        }
    }

    @Transaction
    public List<Book> listBooks() {
        return bookRepository.listBooks();
    }

    @Transaction
    public List<Book> findBooksByTitle(String title) {
        List<Book> books = bookRepository.listBooks().stream()
                .filter(b -> b.getTitle().contains(title))
                .collect(Collectors.toList());

        if (books.isEmpty()) {
            throw new NullPointerException();
        } else return books;
    }
}

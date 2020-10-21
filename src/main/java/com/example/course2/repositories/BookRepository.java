package com.example.course2.repositories;


import com.example.course2.model.Book;

import java.util.List;

public interface BookRepository {

  void addBook(Book book);
  List<Book> listBooks();
}

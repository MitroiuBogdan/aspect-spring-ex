package com.example.course2;

import com.example.course2.model.Book;
import com.example.course2.service.BookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Course2Application implements CommandLineRunner {

    @Autowired
    public BookManagementService bookManagementService;


    public static void main(String[] args) {
        SpringApplication.run(Course2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        bookManagementService.addBook(Book.builder()
                .title("Hero1")
                .author("John Duw")
                .build());

        bookManagementService.addBook(Book.builder()
                .title("Hero")
                .author("John Duw")
                .build());

        bookManagementService.listBooks();


        bookManagementService.findBooksByTitle("123");


        bookManagementService.findBooksByTitle("Hero1");
    }
}

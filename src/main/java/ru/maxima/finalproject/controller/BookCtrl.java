package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.finalproject.model.Book;
import ru.maxima.finalproject.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookCtrl {

    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks () {
        return bookService.allBooks();
    }




}

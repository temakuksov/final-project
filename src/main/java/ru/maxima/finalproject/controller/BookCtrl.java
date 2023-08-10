package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.finalproject.model.Book;
import ru.maxima.finalproject.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookCtrl {

    private final BookService bookService;

    public List<Book> getAllBooks () {
        return bookService.allBooks();
    }
}

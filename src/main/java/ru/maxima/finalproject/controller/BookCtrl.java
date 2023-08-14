package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.maxima.finalproject.model.Book;
import ru.maxima.finalproject.service.BookService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookCtrl {

    private final BookService bookService;

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.allBooks();
    }

    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/addbook/{adminId}")
    public void addBook(@RequestBody Book book, @PathVariable Long adminId) {
        bookService.newBook(book, adminId);
    }

}

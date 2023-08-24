package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.maxima.finalproject.exeptions.BookNotFoundException;
import ru.maxima.finalproject.model.Book;
import ru.maxima.finalproject.service.impl.BookServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookCtrl {

    private final BookServiceImpl bookService;

    // получить список всех книг
    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        if (allBooks == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (allBooks.isEmpty())
            return new ResponseEntity<>(allBooks, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }


    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        boolean isBookCreated = bookService.createBook(book);

        if (isBookCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Book created successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create Book!");
        }
    }

    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/remove/{bookId}")
    public void removeBookById(@PathVariable Long bookId) throws BookNotFoundException {
        bookService.removeBookById(bookId);
    }

    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/edit")
    public ResponseEntity<String> editBook(@RequestBody Book book) throws BookNotFoundException {
        boolean isBookEdited = bookService.editBook(book);
        if (isBookEdited) {
            return ResponseEntity.status(HttpStatus.OK).body("Book is updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BookNotFoundException().getMessage());
        }
    }

    @PostMapping("/take/{bookId}")
    public ResponseEntity<String> takeBook(@PathVariable Long bookId) {

        boolean isTakenBook = bookService.takeBook(bookId);
        if (isTakenBook) {
            return ResponseEntity.status(HttpStatus.OK).body("Book is taken successfully");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found / book was taken!");
    }

    @PostMapping("/return/{bookId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId) {

        boolean isReturnedBook = bookService.returnBook(bookId);
        if (isReturnedBook) {
            return ResponseEntity.status(HttpStatus.OK).body("Book is returned successfully");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("You can't return this book!");
    }


}

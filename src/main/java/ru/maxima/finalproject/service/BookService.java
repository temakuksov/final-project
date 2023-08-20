package ru.maxima.finalproject.service;

import org.springframework.http.ResponseEntity;
import ru.maxima.finalproject.model.Book;


import java.util.List;

public interface BookService {

    // показать все (активные) книги +
    List<Book> getAllBooks();

    // добавить книгу (админ) +
    boolean createBook (Book book);

    // отметить книгу как удаленную книгу (админ) +
    void removeBookById(Long bookId);

    // редактировать книгу (админ)
    boolean editBook(Book book);

    // взять книгу (любой авторизовавшийся)
    boolean takeBook (Long bookId);

    // вернуть книгу (любой авторизовавшийся)
    ResponseEntity<Book> returnBook (Book book);

}

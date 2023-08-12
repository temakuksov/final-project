package ru.maxima.finalproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.finalproject.model.Book;
import ru.maxima.finalproject.repository.BookRepo;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    public List<Book> allBooks() {
        return bookRepo.findAll();
    }

}

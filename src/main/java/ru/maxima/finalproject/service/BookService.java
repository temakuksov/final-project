package ru.maxima.finalproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxima.finalproject.model.Book;
import ru.maxima.finalproject.repository.BookRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    public List<Book> allBooks () {
        return bookRepo.findAll();
    }

}

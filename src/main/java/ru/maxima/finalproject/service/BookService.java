package ru.maxima.finalproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.finalproject.model.Book;
import ru.maxima.finalproject.repository.BookRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;
    private final PersonService personService;

    // не отображать удаленные книги
    public List<Book> allBooks() {
        return bookRepo.findByRemovedAtIsNull();
    }

    public void newBook(Book book, Long adminId){
        Book bookForSave = Book.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .yearOfProduction(book.getYearOfProduction())
                .annotation(book.getAnnotation())
                .createdPerson(personService.getPersonName(adminId))
                .createdAt(LocalDateTime.now())
                .build();
        bookRepo.save(bookForSave);
    }

    // показать все (активные) книги +

    // добавить книгу (админ) +

    // удалить книгу (админ)

    // редактировать книгу (админ)

    // взять книгу

    // вернуть книгу

}

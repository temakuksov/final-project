package ru.maxima.finalproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.finalproject.config.Authorities;
import ru.maxima.finalproject.model.Book;
import ru.maxima.finalproject.repository.BookRepo;
import ru.maxima.finalproject.service.BookService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final JwtServiceImpl jwtService;

    // список книг - не отображать удаленные книги
    @Override
    public List<Book> getAllBooks() {
        // return bookRepo.findByRemovedAtIsNull();
        if (jwtService.getUserNameFromToken().getRole().equals(Authorities.ROLE_ADMIN)) {
            return bookRepo.findAll();
        } else {
            return bookRepo.findByRemovedAtIsNull();
        }

    }

    @Override
    public boolean createBook(Book book) {
        // Проверяем есть ли уже книга с таким автором и таким названием
        if (bookRepo.existsByAuthorAndName(book.getAuthor(), book.getName())) {
            return false;
        }
        Book bookForSave = Book.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .yearOfProduction(book.getYearOfProduction())
                .annotation(book.getAnnotation())
                .createdPerson(jwtService.getUserNameFromToken().getName())
                .createdAt(LocalDateTime.now())
                .build();
        bookRepo.save(bookForSave);
        return true;
    }

    @Override
    public void removeBookById(Long bookId) {

        //System.out.println("  ### Remove book!!! "+bookRepo.findById(bookId));

        //if (bookRepo.findById(bookId).)

        String removedPersonName = jwtService.getUserNameFromToken().getName();

        Book bookForRemove = bookRepo.findBookById(bookId);
        bookForRemove.setRemovedAt(LocalDateTime.now());
        bookForRemove.setRemovedPerson(removedPersonName);
        bookForRemove.setUpdatedAt(LocalDateTime.now());
        bookForRemove.setUpdatedPerson(removedPersonName);
        bookRepo.save(bookForRemove);

    }

    @Override
    public boolean editBook(Book book) {
        if (bookRepo.existsById(book.getId())) {
            String updatePersonName = jwtService.getUserNameFromToken().getName();
            Book bookForUpdate = bookRepo.getReferenceById(book.getId());

            bookForUpdate.setName(book.getName());
            bookForUpdate.setAuthor(book.getAuthor());
            bookForUpdate.setYearOfProduction(book.getYearOfProduction());
            bookForUpdate.setAnnotation(book.getAnnotation());

            bookForUpdate.setUpdatedPerson(updatePersonName);
            bookForUpdate.setUpdatedAt(LocalDateTime.now());

            bookRepo.save(bookForUpdate);
            return true;
        }
        return false;
    }

    @Override
    // @Cascade()
    public boolean takeBook(Long bookId) {
         if (bookRepo.existsById(bookId)) {
            Book bookForTake = bookRepo.findBookById(bookId);
            if (bookForTake.getOwner() == null) {
                bookForTake.setOwner(jwtService.getUserNameFromToken());
                bookRepo.save(bookForTake);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean returnBook(Long bookId) {
        if (bookRepo.existsById(bookId)) {
            Book bookForReturn = bookRepo.findBookById(bookId);
            if ((bookForReturn.getOwner() != null)
                    && (bookForReturn.getOwner().getId().equals(jwtService.getUserNameFromToken().getId()))) {
                bookForReturn.setOwner(null);
                bookRepo.save(bookForReturn);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}

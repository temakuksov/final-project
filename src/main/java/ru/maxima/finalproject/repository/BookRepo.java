package ru.maxima.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.finalproject.model.Book;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Long> {

  //@Query(value = "SELECT * FROM BOOK b WHERE b.removedAt is null", nativeQuery = true)

  List<Book> findByRemovedAtIsNull();


}

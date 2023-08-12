package ru.maxima.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.finalproject.model.Book;

public interface BookRepo extends JpaRepository<Book,Long> {

}

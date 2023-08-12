package ru.maxima.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.finalproject.model.Person;

public interface PersonRepo extends JpaRepository <Person,Long> {

}

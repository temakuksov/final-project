package ru.maxima.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxima.finalproject.model.Person;

@Repository
public interface PersonRepo extends JpaRepository <Person,Long> {

}

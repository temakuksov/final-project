package ru.maxima.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.maxima.finalproject.model.Person;

import java.util.Optional;

public interface PersonRepo extends JpaRepository <Person,Long> {

    @Query("select p.name from #{#entityName} p where p.id=?1")
    String findBy(Long adminId);

    @Query
    Optional<Person> findByEmail(String email);



}

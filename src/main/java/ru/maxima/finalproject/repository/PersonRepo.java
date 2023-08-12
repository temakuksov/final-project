package ru.maxima.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.maxima.finalproject.model.Person;

public interface PersonRepo extends JpaRepository <Person,Long> {

    @Query
    Person getPersonById(Long adminId);

}

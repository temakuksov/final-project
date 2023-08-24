package ru.maxima.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.finalproject.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Long> {

    // @Query("select p.name from #{#entityName} p where p.id=?1")
    // String findBy(Long adminId);

    Optional<Person> findPersonById(Long adminId);

    Optional<Person> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Person> findPersonByRemovedAtIsNull();

    List<Person> findPersonByRemovedAtIsNotNull();
}

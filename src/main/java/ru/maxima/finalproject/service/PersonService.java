package ru.maxima.finalproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.repository.PersonRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepo personRepo;

    public List<Person> allPerson() {
        return personRepo.findAll();
    }
}

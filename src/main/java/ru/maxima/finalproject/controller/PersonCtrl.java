package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonCtrl {

    private final PersonService personService;

    public List<Person> getAllPersons () {
        return personService.allPerson();
    }


}

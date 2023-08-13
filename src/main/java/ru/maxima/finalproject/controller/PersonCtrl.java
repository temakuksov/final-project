package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonCtrl {

    private final PersonService personService;

    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons () {
        return personService.allPerson();
    }


}

package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.service.impl.AuthServiceImpl;
import ru.maxima.finalproject.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonCtrl {

    private final PersonService personService;
    private final AuthServiceImpl authService;

    // получить список всех пользователей
    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @GetMapping("/getall/{adminId}")
    public List<Person> getAllPersons () {
        return personService.allPerson();
    }

    // добавление (регистрация) нового пользователя
    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/reg/{adminId}")
    public void registration (@RequestBody Person user, @PathVariable Long adminId) {
        authService.registration(user, adminId);
    }
}

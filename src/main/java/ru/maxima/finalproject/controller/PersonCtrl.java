package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.service.impl.PersonServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonCtrl {

    private final PersonServiceImpl personService;

    // получить список всех персон (пользователей)
    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @GetMapping()
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    // получить одну персону (пользователя)
    @GetMapping("/{personId}")
    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    public Optional<Person> getOnePerson(@PathVariable Long personId) {
        return personService.getOnePerson(personId);
    }

    // заблокировать одну персону (пользователя)
    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/remove")
    public ResponseEntity<String> removePerson(@RequestBody Person person) {
        boolean isPersonBlocked = personService.removePerson(person);

        if (isPersonBlocked) {
            return ResponseEntity.status(HttpStatus.OK).body("Person is blocked successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to block person");
        }
    }

    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/add")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        boolean isPersonCreated = personService.createPerson(person);

        if (isPersonCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Person is created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create person");
        }


    }

    // редактировать одну персону (пользователя
    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/edit")
    public ResponseEntity<String> editPerson(@RequestBody Person person) {
        boolean isPersonEdited = personService.editPerson(person);
        if (isPersonEdited) {
            return ResponseEntity.status(HttpStatus.OK).body("Person is updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
        }
    }


    // добавление (регистрация) новой персоны (пользователя)

   /* @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/reg/{adminId}")
    public void registration(@RequestBody Person user, @PathVariable Long adminId) {
        authService.registration(user, adminId);
    }*/

}

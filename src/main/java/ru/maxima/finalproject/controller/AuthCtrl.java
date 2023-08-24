package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.maxima.finalproject.config.detail.PersonDetailsService;
import ru.maxima.finalproject.exeptions.UserNotFoundException;
import ru.maxima.finalproject.service.AuthService;
import ru.maxima.finalproject.model.Person;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthCtrl {

    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;
    private final PersonDetailsService personDetailsService;

    // служебный метод который возвращает токен для теста
    @GetMapping("/get-token")
    public String authentication(@RequestBody Person person) {
        return authService.authentication(person);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginPerson(@RequestBody Person person) throws UserNotFoundException {
        try {
            UserDetails personDetails = personDetailsService.loadUserByUsername(person.getEmail());
            if (!personDetails.isEnabled()) return ResponseEntity.status(HttpStatus.LOCKED).body("Person is blocked!");
            if (passwordEncoder.matches(person.getPassword(), personDetails.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body("Person logged successfully \nToken:\n" +  authService.authentication(person));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Person failed to login");
        } catch (UserNotFoundException ue) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ue.getMessage());
        }
    }

}

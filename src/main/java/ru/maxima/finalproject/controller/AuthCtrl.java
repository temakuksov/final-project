package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.maxima.finalproject.service.AuthService;
import ru.maxima.finalproject.model.Person;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthCtrl {

    private final AuthService authService;

    @GetMapping("/login")
    public String authentication (@RequestBody Person person) {
        return authService.authentication(person);
    }

}

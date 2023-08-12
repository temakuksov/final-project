package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.finalproject.interfaces.AuthService;
import ru.maxima.finalproject.model.Person;

import java.time.Period;

@RestController
@RequiredArgsConstructor
public class AuthCtrl {

    private AuthService authService;

    public void registration (Person user) {
        authService.registration();
    }

    public String authentication () {
        return null;
    }



}

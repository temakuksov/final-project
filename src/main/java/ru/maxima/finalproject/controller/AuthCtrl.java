package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.maxima.finalproject.interfaces.AuthService;
import ru.maxima.finalproject.model.Person;

import java.time.LocalDateTime;
import java.time.Period;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AuthCtrl {

    private final AuthService authService;

    @PostMapping("/reg/{adminId}")
    public void registration (@RequestBody Person user, @PathVariable Long adminId) {
        authService.registration(user, adminId);
    }

    public String authentication () {
        return null;
    }


}

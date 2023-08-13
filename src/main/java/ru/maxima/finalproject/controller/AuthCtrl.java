package ru.maxima.finalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.maxima.finalproject.interfaces.AuthService;
import ru.maxima.finalproject.model.Person;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthCtrl {

    private final AuthService authService;


    @PreAuthorize("hasAnyAuthority(@authorities.ROLE_ADMIN)")
    @PostMapping("/reg/{adminId}")
        public void registration (@RequestBody Person user, @PathVariable Long adminId) {
        authService.registration(user, adminId);
    }

    @GetMapping("/login")
    public String authentication (@RequestBody Person person) {
        return authService.authentication(person);
    }


}

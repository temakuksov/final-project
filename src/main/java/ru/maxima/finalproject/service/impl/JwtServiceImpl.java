package ru.maxima.finalproject.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.maxima.finalproject.exeptions.UserNotFoundExeption;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.repository.PersonRepo;
import ru.maxima.finalproject.service.JwtService;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    public static final String SECRET = "1234567890";
    private final PersonRepo repo;


    @Override
    public String getToken(Person person) {
        Person personFromDB = repo
                .findByEmail(person.getEmail())
                .orElseThrow(UserNotFoundExeption::new);

        return JWT.create()
                .withClaim("Email", personFromDB.getEmail())
                .withClaim("Role", personFromDB.getRole())
                .withClaim("Name", personFromDB.getName())
                .sign(Algorithm.HMAC256(SECRET));
    }

    @Override
    public Person getUserNameFromToken() {
        return ((Person) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal());
    }

}

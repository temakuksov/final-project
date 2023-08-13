package ru.maxima.finalproject.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxima.finalproject.exeptions.UserNotFoundExeption;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.repository.PersonRepo;

@Service
@RequiredArgsConstructor
public class JwtService {

    public static final String SECRET = "1234567890";
    private final PersonRepo repo;

    public String getToken(Person person) {
        Person personFromDB = repo.findByEmail(person.getEmail()).orElseThrow(UserNotFoundExeption::new);

        return JWT.create()
                .withClaim("Email", personFromDB.getEmail())
                .withClaim("Role", personFromDB.getRole())
                .sign(Algorithm.HMAC256(SECRET));

    }
}

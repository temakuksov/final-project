package ru.maxima.finalproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.service.AuthService;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;

   /* @Override
    public void registration(Person user, Long adminId) {
        Person personForSave = Person.builder()
                .name(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .role(Authorities.ROLE_USER)
                .createdAt(LocalDateTime.now())
                .createdPerson(personService.getPersonName(adminId))
                .build();
        personRepo.save(personForSave);
    }*/

    // !!!добавить проверку на незаблокированного пользователя
    @Override
    public String authentication(Person person) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(person.getEmail(), person.getPassword());
            authenticationManager.authenticate(authenticationToken);
            return jwtService.getToken(person);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}

package ru.maxima.finalproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.finalproject.interfaces.AuthService;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.repository.PersonRepo;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PersonRepo personRepo;
    @Override
    public void registration(Person user, Long adminId) {
        Person personForSave = Person.builder()
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .role("User")
                .createdAt(LocalDateTime.now())
                .createdPerson(personRepo.getPersonById(adminId).getName())
                .build();
        personRepo.save(personForSave);

    }

    @Override
    public String authentication() {
        return null;
    }
}

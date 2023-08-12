package ru.maxima.finalproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.finalproject.interfaces.AuthService;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.repository.PersonRepo;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private PersonRepo personRepo;
    @Override
    public void registration() {

    }

    @Override
    public String authentication() {
        return null;
    }
}

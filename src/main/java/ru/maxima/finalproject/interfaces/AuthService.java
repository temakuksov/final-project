package ru.maxima.finalproject.interfaces;

import ru.maxima.finalproject.model.Person;

public interface AuthService {

    void registration(Person person, Long adminId);

    String authentication();

}

package ru.maxima.finalproject.service;

import ru.maxima.finalproject.model.Person;

public interface JwtService {

    // создать и возвратить токен пользователю
     String getToken(Person person);

     // получить имя пользователя из токена
     Person getUserNameFromToken();

}

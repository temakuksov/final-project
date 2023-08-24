package ru.maxima.finalproject.service;

import ru.maxima.finalproject.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> getAllPersons(boolean blocked);

    // добавить персону в базу (регистрация)
    boolean createPerson(Person person);

    // получить список всех персон
    // List<Person> getAllPersons();

    // редактировать персону
    boolean editPerson (Person person);

    // заблокировать пользователя (removedAt)
    boolean removePerson (Person person);

    // получить имя персоны из базы
    Person getPersonFromDB(String email);

    // получить персону по id
    Optional<Person> getOnePerson(Long personId);


    // показать всех персон ?

    // добавлять пользователя-персону + (в authCtrl)

    // удалить (заблокировать) персону

    // редактировать персону

}

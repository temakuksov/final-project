package ru.maxima.finalproject.service;

import ru.maxima.finalproject.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    // добавить персону в базу (регистрация)
    boolean createPerson(Person person);

    // получить список всех персон
    List<Person> getAllPersons();

    // редактировать персону
    boolean editPerson (Person person);

    // заблокировать пользователя (removedAt)
    boolean blockPerson (Person person);

    // получить имя персоны из базы
    String getPersonNameFromDB(Long id);

    // получить персону по id
    Optional<Person> getOnePerson(Long personId);


    // показать всех персон ?

    // добавлять пользователя-персону + (в authCtrl)

    // удалить (заблокировать) персону

    // редактировать персону

}

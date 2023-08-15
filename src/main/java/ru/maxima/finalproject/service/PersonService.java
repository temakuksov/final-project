package ru.maxima.finalproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.repository.PersonRepo;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepo personRepo;

    public String getPersonName(Long id) {
        return personRepo.findPersonById(id).get().getName();
    }

    public List<Person> allPerson() {
        return personRepo.findAll();
    }




    // показать всех персон ?

    // добавлять пользователя-персону + (в authCtrl)

    // удалить (заблокировать) персону

    // редактировать персону

}

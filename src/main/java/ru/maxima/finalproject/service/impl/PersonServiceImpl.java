package ru.maxima.finalproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.finalproject.config.Authorities;
import ru.maxima.finalproject.exeptions.UserNotFoundExeption;
import ru.maxima.finalproject.model.Person;
import ru.maxima.finalproject.repository.PersonRepo;
import ru.maxima.finalproject.service.JwtService;
import ru.maxima.finalproject.service.PersonService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final JwtService jwtService;
    private final PersonRepo personRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    @Override
    public boolean createPerson(Person person) {
        // check id person already exist
        if (personRepo.existsByEmail(person.getEmail())) {
            return false;
        }
        Person personForSave = Person.builder()
                .name(person.getName())
                .createdPerson(jwtService.getUserNameFromToken().getName())
                .password(passwordEncoder.encode(person.getPassword()))
                .email(person.getEmail())
                .role(Authorities.ROLE_USER)
                .createdAt(LocalDateTime.now())
                .build();
        personRepo.save(personForSave);

        return true;
    }

    @Override
    public boolean editPerson(Person person) {
        if (personRepo.existsByEmail(person.getEmail())) {

            Person personForUpdate = personRepo.getReferenceById(person.getId());

            personForUpdate.setName(person.getName());
            personForUpdate.setAge(person.getAge());
            personForUpdate.setPhoneNumber(person.getPhoneNumber());
            personForUpdate.setPassword(passwordEncoder.encode(person.getPassword()));
            personForUpdate.setRole(person.getRole());

            personRepo.save(personForUpdate);
            return true;
        }
        return false;
    }

    @Override
    public boolean blockPerson(Person person) {
        if (personRepo.existsById(person.getId())) {
            if (personRepo.getReferenceById(person.getId()).getRemovedAt() == null) {
                personRepo.getReferenceById(person.getId()).setRemovedPerson(jwtService.getUserNameFromToken().getName());
                personRepo.getReferenceById(person.getId()).setRemovedAt(LocalDateTime.now());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String getPersonNameFromDB(Long id) {
        return personRepo.findPersonById(id).orElseThrow(UserNotFoundExeption::new).getName();
    }

    @Override
    public Optional<Person> getOnePerson(Long personId) {
        Optional<Person> p = personRepo.findPersonById(personId);
        if (p.isPresent()) {
            return p;
        } else throw new UserNotFoundExeption();
    }
}

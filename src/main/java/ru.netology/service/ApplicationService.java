package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.entity.Person;
import ru.netology.repository.ApplicationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Person> getPersonByCity(String city) {
        return applicationRepository.findPersonsByCity(city);
    }

    public List<Person> getPersonsByAgeLessThan(int age) {
        return applicationRepository.findPersonsByAgeLessThan(age);
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return applicationRepository.findPersonByNameAndSurname(name, surname);
    }

}

package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.entity.Person;
import ru.netology.service.ApplicationService;

import java.util.List;
import java.util.Optional;

@RestController
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonByCity(@RequestParam("city") String city) {
        return applicationService.getPersonByCity(city);
    }

    @GetMapping("/persons/age-less-than")
    public List<Person> getPersonsByAgeLessThan(@RequestParam("age") int age) {
        return applicationService.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname) {
        return applicationService.getPersonByNameAndSurname(name, surname);
    }

}
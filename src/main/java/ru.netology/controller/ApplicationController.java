package ru.netology.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.entity.Person;
import ru.netology.service.ApplicationService;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List<Person> getPersonByCity(@RequestParam("city") String city) {
        return applicationService.getPersonByCity(city);
    }

    @GetMapping("/persons/age-less-than")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> getPersonsByAgeLessThan(@RequestParam("age") int age) {
        return applicationService.getPersonsByAgeLessThan(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Optional<Person> getPersonByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname) {
        return applicationService.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/persons/all")
    @PreAuthorize("authentication.principal.username == 'zaur'")
    public List<Person> findAll() {
        return applicationService.getAllPersons();
    }

}
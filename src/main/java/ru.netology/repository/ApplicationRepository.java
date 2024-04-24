package ru.netology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.entity.Person;
import ru.netology.entity.PersonKey;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Person, PersonKey> {

    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findPersonsByCity(@Param("city") String city);

    @Query("SELECT p FROM Person p WHERE p.personKey.age < :age ORDER BY p.personKey.age ASC")
    List<Person> findPersonsByAgeLessThan(@Param("age") int age);

    @Query("SELECT p FROM Person p WHERE p.personKey.name = :name AND p.personKey.surname = :surname")
    Optional<Person> findPersonByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}

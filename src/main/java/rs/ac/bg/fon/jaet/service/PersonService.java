package rs.ac.bg.fon.jaet.service;

import rs.ac.bg.fon.jaet.model.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person);

    List<Person> findAll();

    Person findById(Long id);

    Person update(Person person, Long personId);

    void deleteById(Long personId);

}

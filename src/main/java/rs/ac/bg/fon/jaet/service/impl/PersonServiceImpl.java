package rs.ac.bg.fon.jaet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.jaet.exception.PersonDoesNotExistException;
import rs.ac.bg.fon.jaet.model.Person;
import rs.ac.bg.fon.jaet.repository.PersonRepository;
import rs.ac.bg.fon.jaet.service.PersonService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long personId) {
        Optional<Person> optionalPerson = personRepository.findById(personId);

        if (optionalPerson.isEmpty()) {
            throw new PersonDoesNotExistException("Person with given id doesn't exist.");
        }

        return optionalPerson.get();
    }

    @Override
    public Person update(Person person, Long personId) {
        Optional<Person> optionalPerson = personRepository.findById(personId);

        if (optionalPerson.isEmpty()) {
            throw new PersonDoesNotExistException("Person with given id doesn't exist.");
        }

        person.setId(optionalPerson.get().getId());
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Long personId) {
        personRepository.deleteById(personId);
    }

}

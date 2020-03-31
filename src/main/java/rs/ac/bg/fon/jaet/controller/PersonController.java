package rs.ac.bg.fon.jaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.jaet.model.Person;
import rs.ac.bg.fon.jaet.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("persons")
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @GetMapping("persons")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("persons/{personId}")
    public Person findById(@PathVariable Long personId) {
        return personService.findById(personId);
    }

    @PutMapping("persons/{personId}")
    public Person update(@RequestBody Person person,
                         @PathVariable Long personId) {
        return personService.update(person, personId);
    }

    @DeleteMapping("persons/{personId}")
    public void deleteById(@PathVariable Long personId) {
        personService.deleteById(personId);
    }

}

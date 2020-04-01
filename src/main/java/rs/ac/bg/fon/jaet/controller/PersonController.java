package rs.ac.bg.fon.jaet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.bg.fon.jaet.dto.PersonDto;
import rs.ac.bg.fon.jaet.model.Person;
import rs.ac.bg.fon.jaet.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("persons")
    public PersonDto create(@RequestBody Person person) {
        return new PersonDto(personService.create(person));
    }

    @GetMapping("persons")
    public List<PersonDto> findAll() {
        return personService.findAll().stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("persons/{personId}")
    public PersonDto findById(@PathVariable Long personId) {
        return new PersonDto(personService.findById(personId));
    }

    @PutMapping("persons/{personId}")
    public PersonDto update(@RequestBody Person person,
                            @PathVariable Long personId) {
        return new PersonDto(personService.update(person, personId));
    }

    @DeleteMapping("persons/{personId}")
    public void deleteById(@PathVariable Long personId) {
        personService.deleteById(personId);
    }

}

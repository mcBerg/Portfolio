package org.berg.portfolio.person;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PutMapping("/person/add")
    public PersonEntity addPerson(@RequestBody PersonEntity person) {
        log.info("Adding Person {}", person);
        return personService.savePerson(person);
    }

    @GetMapping("/person/all")
    public List<PersonEntity> findAllPersons() {
        log.info("Get Everybody!");
        return personService.findAll();
    }

}

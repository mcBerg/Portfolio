package org.berg.portfolio.person;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    PersonEntity getPersonById(UUID id) {
        return personRepository.findById(id).orElse(null);
    }

    PersonEntity savePerson(PersonEntity person) {
        return personRepository.save(person);
    }

    public List<PersonEntity> findAll() {
        return personRepository.findAll();
    }
}

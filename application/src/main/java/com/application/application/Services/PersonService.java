package com.application.application.Services;

import com.application.application.Person.Person;
import com.application.application.Repositories.interfaces.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    public IPersonRepository personRepository;

    public Person findById(Long id) throws Exception{

        logger.info("Search for a person with id = " + id);

        return personRepository.findById(id).orElseThrow(()
                -> new Exception("Person not found"));
    }

    public Person create(Person person) {

        logger.info("Person created ");

        return personRepository.save(person);
    }


    public Person update(Person person) throws Exception{

        logger.info("Person updated ");

        Person entity = personRepository.findById(person.getId()).orElseThrow(()
                -> new Exception("Person not found"));

        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());


        return personRepository.save(entity);
    }


    public void delete(Long id) throws Exception{

        logger.info("Person deleted ");

        Person entity = personRepository.findById(id).orElseThrow(()
                -> new Exception("Person not found"));
        personRepository.delete(entity);
    }


    public List<Person> getAll() {

        logger.info("Get All Persons");
        return personRepository.findAll();
    }
}

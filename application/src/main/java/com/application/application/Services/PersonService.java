package com.application.application.Services;

import com.application.application.Mapper.DozerMapper;
import com.application.application.Models.Person.Person;
import com.application.application.Repositories.IPersonRepository;
import com.application.application.VO.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());


    @Autowired
    public IPersonRepository personRepository;

    public List<PersonVO> getAll() {

        logger.info("Get All Persons");

        return DozerMapper.ParseListObject(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) throws Exception {

        logger.info("Search for a person with id = " + id);

        return DozerMapper.ParseObject(personRepository.findById(id).orElseThrow(()
                -> new Exception("Person not found")), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {

        logger.info("Person created ");
        return DozerMapper.ParseObject(personRepository.save(DozerMapper.ParseObject(person, Person.class)), PersonVO.class);
    }


    public PersonVO update(PersonVO person) throws Exception {

        logger.info("Person updated ");

        Person entity = personRepository.findById(person.getId()).orElseThrow(()
                -> new Exception("Person not found"));

        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());


        return DozerMapper.ParseObject(personRepository.save(entity), PersonVO.class);
    }


    public void delete(Long id) throws Exception {

        logger.info("Person deleted ");

        Person entity = personRepository.findById(id).orElseThrow(()
                -> new Exception("Person not found"));
        personRepository.delete(entity);
    }
}

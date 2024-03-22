package com.application.application.Controllers.Person;


import com.application.application.Person.Person;
import com.application.application.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findBydId(@PathVariable(value = "id") Long id) throws Exception {
        return personService.findById(id);
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {

        return personService.getAll();
    }



    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Person person) throws Exception {
        return ResponseEntity.ok(personService.create(person));
    }



    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Person person) throws Exception {
        return ResponseEntity.ok(personService.update(person));
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable(value = "id") Long id) throws Exception {
        personService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}

package com.application.application.mocks;

import com.application.application.Models.Person.Person;
import com.application.application.VO.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {
    public Person mockEntity(){
        return mockEntity(0);
    }

    public PersonVO mockEntityVO(){
        return mockEntityVO(0);
    }


    public List<Person> mockEntityList(){
        var persons = new ArrayList<Person>();
        for(int i=0; i < 10; i++){
            persons.add(mockEntity(i));
        }
        return persons;
    }


    public List<PersonVO> mockEntityListVO(){
        var persons = new ArrayList<PersonVO>();
        for(int i=0; i < 10; i++){
            persons.add(mockEntityVO(i));
        }
        return persons;
    }

    public Person mockEntity(Integer number){
        var person = new Person();
        person.setAddress("Address test" + number);
        person.setFirstName("First name" + number);
        person.setLastName("Last name" + number);
        person.setGender(number % 2 == 0 ? "Male" : "Female");
        person.setId(number.longValue());
        return person;
    }


    public PersonVO mockEntityVO(Integer number){
        var person = new PersonVO();
        person.setAddress("Address test" + number);
        person.setFirstName("first name " + number);
        person.setLastName("last name " + number);
        person.setGender(number % 2 == 0 ? "male" : "female");
        person.setId(number.longValue());
        return person;
    }
}

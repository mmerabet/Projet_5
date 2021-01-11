package com.openclassrooms.safetyAlerts.dao;

import com.openclassrooms.safetyAlerts.model.Person;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface IPersonDAO {

    boolean createPerson(Person person);
    boolean deletePerson(Person person);
    boolean updatePerson(Person person);

    List<Person> getPersons();
    Collection<Person> getPersonsByCity(String city);
    List<Person> getPersonsByName(String lastName, String firstName);
    List<Person> getPersonByAddress(String address);
}

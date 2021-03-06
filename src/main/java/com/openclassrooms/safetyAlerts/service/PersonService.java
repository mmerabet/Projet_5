package com.openclassrooms.safetyAlerts.service;

import com.openclassrooms.safetyAlerts.dao.Person;
import com.openclassrooms.safetyAlerts.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashSet;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private DataRepository dataRepository;

// C'est une méthode pour récupérer la liste des Emails avec city en paramètre
    @Override
    public Collection<String> getCommunityEmail(String city) {
        Collection<String> personEmail = new HashSet<String>();
        for (Person person : dataRepository.getPersonsByCity(city)) {
            personEmail.add(person.getEmail());
        }
        return personEmail;
    }
}

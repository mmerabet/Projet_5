package com.openclassrooms.safetyAlerts.service;

import com.openclassrooms.safetyAlerts.Interface.IpersonInfoService;
import com.openclassrooms.safetyAlerts.dao.IMedicalrecordDAO;
import com.openclassrooms.safetyAlerts.dao.IPersonDAO;
import com.openclassrooms.safetyAlerts.model.Medicalrecord;
import com.openclassrooms.safetyAlerts.model.Person;
import com.openclassrooms.safetyAlerts.dto.PersonInfo;
import com.openclassrooms.safetyAlerts.repository.DataRepository;
import com.openclassrooms.safetyAlerts.utility.CalculateAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PersonInfoService implements IpersonInfoService {

    @Autowired
    private IPersonDAO personDAO;

    @Autowired
    private IMedicalrecordDAO medicalrecordDAO;

    @Override
    public Collection<PersonInfo> getPersonInfo(String lastName, String firstName) {
        Collection<PersonInfo> personInfoCollection = new ArrayList<>();
        List<Person> personList = personDAO.getPersonsByName(lastName, firstName);
        for (Person person : personList) {
            PersonInfo personInfo = new PersonInfo();
            personInfo.setFirstName(person.getFirstName());
            personInfo.setLastName(person.getLastName());
            personInfo.setAddress(person.getAddress());
            personInfo.setEmail(person.getEmail());

            Medicalrecord medicalrecordPerson = medicalrecordDAO.getMedicalRecordByName(person.getLastName(), person.getFirstName());
            personInfo.setMedications(medicalrecordPerson.getMedications());
            personInfo.setAllergies(medicalrecordPerson.getAllergies());
            personInfo.setAge(CalculateAge.calculateAge(medicalrecordPerson.getBirthdate()));
            // si on veut rajouter la date de naissance personInfo.setBirthdate(medicalrecordPerson.getBirthdate());

            personInfoCollection.add(personInfo);
        }
        return personInfoCollection;
    }
}


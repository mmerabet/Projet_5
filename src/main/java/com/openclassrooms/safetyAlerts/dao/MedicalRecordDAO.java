package com.openclassrooms.safetyAlerts.dao;

import com.openclassrooms.safetyAlerts.model.Medicalrecord;
import com.openclassrooms.safetyAlerts.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordDAO implements IMedicalrecordDAO {

    @Autowired
    DataRepository dataRepository;


    @Override
    public boolean createMedicalrecord(Medicalrecord medicalrecord) {

        dataRepository.getDatabase().getMedicalrecords().add(medicalrecord);

        dataRepository.commit();

        return true;
    }

    @Override
    public boolean deleteMedicalrecord(Medicalrecord medicalrecord) {
        boolean result=dataRepository.getDatabase().getMedicalrecords().remove(medicalrecord);
        // commit
        dataRepository.commit();

        return result;
    }

    @Override
    public boolean updateMedicalrecord(Medicalrecord medicalrecord) {
        if (dataRepository.getDatabase().getMedicalrecords().remove(medicalrecord)) {
            createMedicalrecord(medicalrecord);
            return true;
        }
        return false;
    }
}
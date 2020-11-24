package com.openclassrooms.safetyAlerts.service;

import com.openclassrooms.safetyAlerts.dto.ChildAlert;
import com.openclassrooms.safetyAlerts.dto.Fire;

import java.util.Collection;

public interface IChildAlertService {

    Collection<ChildAlert> getChildAlert(String address);
}

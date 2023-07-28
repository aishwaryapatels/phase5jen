package com.vaccination.service;

import java.util.List;

import com.vaccination.entity.Citizen;
import com.vaccination.entity.VaccineCenter;

public interface CitizenService {
	void addCitizen(Citizen citizen);

	void updateCitizen(Citizen citizen);

	void deleteCitizen(Long id);

	Citizen getCitizenById(Long id);

	List<Citizen> getAllCitizens();

	List<Citizen> getCitizensByVaccinationCenter(VaccineCenter vaccineCenter);
}

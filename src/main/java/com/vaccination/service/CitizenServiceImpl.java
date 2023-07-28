package com.vaccination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccination.entity.Citizen;
import com.vaccination.entity.VaccineCenter;
import com.vaccination.repository.CitizenRepository;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	private CitizenRepository citizenRepository;

	@Override
	public void addCitizen(Citizen citizen) {
		citizenRepository.save(citizen);
	}

	@Override
	public void updateCitizen(Citizen citizen) {
		citizenRepository.save(citizen);
	}

	@Override
	public void deleteCitizen(Long id) {
		citizenRepository.deleteById(id);
	}

	@Override
	public Citizen getCitizenById(Long id) {
		return citizenRepository.findById(id).orElseThrow(() -> new NotFoundException("Citizen not found"));
	}

	@Override
	public List<Citizen> getAllCitizens() {
		return citizenRepository.findAll();
	}

	@Override
	public List<Citizen> getCitizensByVaccinationCenter(VaccineCenter vaccineCenter) {
		return citizenRepository.findByVaccinationCenter(vaccineCenter);
	}

	public class NotFoundException extends RuntimeException {

		public NotFoundException(String message) {
			super(message);
		}
	}
}

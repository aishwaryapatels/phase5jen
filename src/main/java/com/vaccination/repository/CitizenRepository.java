package com.vaccination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccination.entity.Citizen;
import com.vaccination.entity.VaccineCenter;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
	// Add custom query methods if needed

	List<Citizen> findByVaccinationCenter(VaccineCenter vaccinationCenter);
}

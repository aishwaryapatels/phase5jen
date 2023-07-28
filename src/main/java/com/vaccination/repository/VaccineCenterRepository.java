package com.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccination.entity.VaccineCenter;

@Repository
public interface VaccineCenterRepository extends JpaRepository<VaccineCenter, Long> {
	// Add custom query methods if needed
}

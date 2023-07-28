package com.vaccination.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "citizens")
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "city")
	private String city;

	@Column(name = "no_of_doses")
	private int noOfDoses;

	@Column(name = "vaccination_status")
	private String vaccinationStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vaccination_center")
	private VaccineCenter vaccinationCenter;

	// Constructors, getters, setters, and other properties

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNoOfDoses() {
		return noOfDoses;
	}

	public void setNoOfDoses(int noOfDoses) {
		this.noOfDoses = noOfDoses;
	}

	public String getVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	public VaccineCenter getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(VaccineCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

}

package com.vaccination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaccination.entity.Citizen;
import com.vaccination.entity.VaccineCenter;
import com.vaccination.service.CitizenService;
import com.vaccination.service.VaccineCenterService;

@Controller
@RequestMapping("/citizens")
public class CitizenController {

	private final CitizenService citizenService;
	private final VaccineCenterService vaccineCenterService;

	@Autowired
	public CitizenController(CitizenService citizenService, VaccineCenterService vaccineCenterService) {
		this.citizenService = citizenService;
		this.vaccineCenterService = vaccineCenterService;
	}

	@GetMapping
	public String getAllCitizens(Model model) {
		List<Citizen> citizens = citizenService.getAllCitizens();
		model.addAttribute("citizens", citizens);
		return "citizen-details";
	}

	@GetMapping("/{id}")
	public String viewCitizen(@PathVariable("id") Long id, Model model) {
		Citizen citizen = citizenService.getCitizenById(id);
		if (citizen != null) {
			model.addAttribute("citizen", citizen);
			return "view-citizen";
		} else {
			// Citizen not found, handle the error scenario
			return "redirect:/citizens";
		}
	}

	@GetMapping("/add")
	public String addCitizen(Model model) {
		List<VaccineCenter> vaccineCenters = vaccineCenterService.getAllVaccineCenters();
		model.addAttribute("vaccineCenters", vaccineCenters);
		model.addAttribute("citizen", new Citizen());
		return "add-citizen";
	}

	@PostMapping("/add")
	public String processAddCitizenForm(@ModelAttribute("citizen") Citizen citizen,
			@RequestParam("vaccineCenterId") Long vaccineCenterId) {
		VaccineCenter vaccineCenter = vaccineCenterService.getVaccineCenterById(vaccineCenterId);
		citizen.setVaccinationCenter(vaccineCenter);
		citizenService.addCitizen(citizen);
		return "redirect:/citizens";
	}

	@GetMapping("/{id}/edit")
	public String showEditCitizenForm(@PathVariable("id") Long id, Model model) {
		Citizen citizen = citizenService.getCitizenById(id);
		if (citizen != null) {
			List<VaccineCenter> vaccineCenters = vaccineCenterService.getAllVaccineCenters();
			model.addAttribute("citizen", citizen);
			model.addAttribute("vaccineCenters", vaccineCenters);
			return "edit-citizen";
		} else {
			// Citizen not found, handle the error scenario
			return "redirect:/citizens";
		}
	}

	@PostMapping("/{id}/edit")
	public String updateCitizen(@PathVariable("id") Long id, @ModelAttribute("citizen") Citizen updatedCitizen,
			@RequestParam("vaccineCenterId") Long vaccineCenterId) {
		VaccineCenter vaccineCenter = vaccineCenterService.getVaccineCenterById(vaccineCenterId);
		Citizen citizen = citizenService.getCitizenById(id);
		if (citizen != null && vaccineCenter != null) {
			citizen.setName(updatedCitizen.getName());
			citizen.setCity(updatedCitizen.getCity());
			citizen.setNoOfDoses(updatedCitizen.getNoOfDoses());
			citizen.setVaccinationStatus(updatedCitizen.getVaccinationStatus());
			citizen.setVaccinationCenter(vaccineCenter);
			// Update other fields as needed
			citizenService.updateCitizen(citizen);
		}
		return "redirect:/citizens";
	}

	@GetMapping("/{id}/delete")
	public String deleteCitizen(@PathVariable("id") Long id) {
		citizenService.deleteCitizen(id);
		return "redirect:/citizens";
	}
}

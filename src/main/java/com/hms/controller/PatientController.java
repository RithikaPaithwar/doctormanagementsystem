package com.hms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.hms.DTO.PatientDTO;
import com.hms.Entity.Patient;
import com.hms.Service.DoctorService;
import com.hms.Service.PatientService;
import com.hms.Util.Converter;

@RequestMapping("/api")
@RestController
	public class PatientController{
	@Autowired
	public PatientService patientService;
	@GetMapping("/patients")
		public ArrayList<Patient> getPatient()
		{
			return patientService.getPatient();
		}
	@GetMapping("patients/{patientId}")
	public Patient getPatientById(@PathVariable("patientId") int patientId)
	{
		return patientService.getPatientById(patientId);
	}
	@PostMapping("/patients")
	public Patient addPatient(@RequestBody Patient patient)
	{
	return patientService.addPatient(patient);	
	}
	@PutMapping("/patients/{patientId}")
	public Patient updatePatient(@PathVariable("patientId") int patientId, @RequestBody Patient patient)
	{
		return patientService.updatePatient(patientId, patient);
	}
	@DeleteMapping("/patients/{patientId}")
	public String deletePatient(@PathVariable("patientId") int patientId)
	{
	return	patientService.deletePatient(patientId);
		
	}
}
	    
	    
	
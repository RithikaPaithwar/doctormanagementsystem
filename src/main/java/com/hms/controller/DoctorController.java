package com.hms.controller;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.Entity.Doctor;
import com.hms.Service.DoctorService;

@RestController
@RequestMapping("/api")
public class DoctorController{
	@Autowired
	public DoctorService doctorService;
	@GetMapping("/doctors")
		public ArrayList<Doctor> getDoctor()
		{
			return doctorService.getAllDoctor();
		}
	@GetMapping("doctors/{doctorId}")
	public Doctor getDoctorById(@PathVariable("doctorId") int doctorId,Doctor doctor)
	{
		return doctorService.getDoctorById(doctorId, doctor);
	}
	@PostMapping("/doctors")
	public Doctor addDoctor(@RequestBody Doctor doctor)
	{
	return doctorService.addDoctor(doctor);	
	}
	@PutMapping("/doctors/{doctorId}")
	public Doctor updateDoctor(@PathVariable("doctorId") int doctorId, @RequestBody Doctor doctor)
	{
		return doctorService.updateDoctor(doctorId, doctor);
	}
	@DeleteMapping("/doctors/{doctorId}")
	public String deleteDoctor(@PathVariable("doctorId") int doctorId)
	{
	return doctorService.deleteDoctor(doctorId);
		
	}
}
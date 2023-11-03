package com.hms.DTO;

import java.util.List;

import com.hms.Entity.Patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDTO {
	
	 private String id;
		
		private String name;
		
		private String specialization;
		
		private Long phoneNumber;
	
		List<Patient> patient;
	
}
	
	
package com.hms.Service;

import java.util.ArrayList;
import java.util.List;


import com.hms.DTO.PatientDTO;
import com.hms.Entity.Patient;

	public interface PatientService {
			Patient addPatient(Patient patient);
			ArrayList<PatientDTO> getAllPatients();
			Patient getPatientById(int id);
			Patient updatePatient(int id,Patient patient);
			String deletePatient(int id);
			ArrayList<Patient> getPatient();
			String assignDoctorToPatient(int did, int pid);
			
}
	

		
		
		
	
  


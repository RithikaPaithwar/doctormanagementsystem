package com.hms.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;



import com.hms.Entity.Doctor;

@Service
public interface DoctorService {
	
	ArrayList<Doctor> getAllDoctor();

	public Doctor getDoctorById(int doctorId,Doctor doctor);

	Doctor addDoctor(Doctor doctor);

	Doctor updateDoctor(int doctorId, Doctor doctor);

	String deleteDoctor(int doctorId);
}


   
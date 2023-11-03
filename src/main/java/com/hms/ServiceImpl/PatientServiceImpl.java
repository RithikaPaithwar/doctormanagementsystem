package com.hms.ServiceImpl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.hms.DTO.PatientDTO;
import com.hms.Entity.Doctor;
import com.hms.Entity.Patient;
import com.hms.Exception.ResourceNotFoundException;
import com.hms.Repository.DoctorRepository;
import com.hms.Repository.PatientRepository;
import com.hms.Service.PatientService;
import com.hms.Util.Converter;


@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public ArrayList<Patient> getPatient()
{
List<Patient> patientList=patientRepository.findAll();
	ArrayList<Patient> patient=new ArrayList<>(patientList);
	return patient;	
}

public Patient addPatient(Patient patient)
{
	
	patientRepository.save(patient);
	return patient;
	
}
@Override
public Patient updatePatient(int patientId, Patient patient)
{
	try
	{
	Patient newPatient=(Patient)patientRepository.findById(patientId).get();
	
	if(patient.getPatient_name()!=null)
	{
		newPatient.setPatient_name(patient.getPatient_name());
	}
	if(patient.getAge()!=null)
	{
		newPatient.setAge(patient.getAge());
	}
	if(patient.getDisease()!=null)
	{
		newPatient.setDisease(patient.getDisease());
	}
	if(patient.getGender()!=null)
	{
		newPatient.setGender(patient.getGender());
	}
patientRepository.save(newPatient);
	return newPatient;
	}
	
	catch(Exception e)
	{
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
@Override
public String deletePatient(int id) 
{
	
	
		patientRepository.deleteById(id);  
	 return ("Patient got deleted successfully!!");
}
      
//@Override
/*public String assignDoctorToPatient(int did, int pid) {
	Patient p=patientRepository.findById(pid).orElseThrow(()->
	new ResourceNotFoundException("Patient", "Id", pid));
	
	Doctor d=doctorRepository.findById(did).orElseThrow(()->
	new ResourceNotFoundException("Doctor", "Id", did));
	
	List<Patient> patients=new ArrayList<>();
	patients.add(p);
	
	//assign patients to doctor
	d.setPatients(patients);
	
	//assign doctors to patients
	p.setDoctor(d);
	
	patientRepository.save(p);
	return "Patients assigned to Doctor successfully";
}*/
@Override
public String assignDoctorToPatient(int did, int pid) {
	Patient p=patientRepository.findById(pid).orElseThrow(()->
	new ResourceNotFoundException("Patient", "Id", pid));
	
	Doctor d=doctorRepository.findById(did).orElseThrow(()->
	new ResourceNotFoundException("Doctor", "Id", did));

	p.setDoctor(d);

	patientRepository.save(p);
	
	return "Patients assigned to Doctor successfully";
}



@Override
public ArrayList<PatientDTO> getAllPatients() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Patient getPatientById(int id) {
	// TODO Auto-generated method stub
	return null;
}
	}




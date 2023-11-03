package com.hms.ServiceImpl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.hms.Entity.Doctor;
import com.hms.Repository.DoctorRepository;
import com.hms.Service.DoctorService;
import com.hms.Util.Converter;


@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private Converter converter;
	
	
	public ArrayList<Doctor> getAllDoctor() 
{
List<Doctor> doctorList=doctorRepository.findAll();
	ArrayList<Doctor> doctors=new ArrayList<>(doctorList);
	return doctors;	
}
public Doctor getDoctorById(int doctorId,Doctor doctor)
{
	try
	{
	 doctor= (Doctor)doctorRepository.findById(doctorId).get();
		return doctor;
	}
	catch(Exception e)
	{
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
public Doctor addDoctor(Doctor doctor)
{
	
	doctorRepository.save(doctor);
	return doctor;
	
}
public Doctor updateDoctor(int doctorId, Doctor doctor)
{
	try
	{
	Doctor newDoctor=(Doctor)doctorRepository.findById(doctorId).get();
	
	if(doctor.getDoctor_name()!=null)
	{
		newDoctor.setDoctor_name(doctor.getDoctor_name());
	}
	
	if(doctor.getSpecialization()!=null)
	{
		newDoctor.setSpecialization(doctor.getSpecialization());
	}
	
	if(doctor.getPhone_number()!=null)
	{
		newDoctor.setPhone_number(doctor.getPhone_number());
	}
	
	doctorRepository.save(newDoctor);
	return newDoctor;
	}
	
	catch(Exception e)
	{
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
public String deleteDoctor(int doctorId)
{
	
	 try
	 {
		 doctorRepository.deleteById(doctorId);
		 return ("doctor removed");
	 }
	 catch(Exception e)
	 {
	 	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	 }

}




}




	
	
  




package com.hms.Util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


import com.hms.DTO.DoctorDTO;
import com.hms.DTO.PatientDTO;
import com.hms.Entity.Doctor;
import com.hms.Entity.Patient;
import com.hms.Entity.User;



@Component
public class Converter 
{
	public  Patient convertToPatientEntity(PatientDTO patientDTO)
	{
		Patient patient=new Patient();
		if(patientDTO!=null)
		{
			BeanUtils.copyProperties(patientDTO,patient);
		}
	     return patient;
	}

	//convert from Entity to DTO
	public PatientDTO convertToPatientDTO(Patient patient)
	{
		PatientDTO patientDTO=new PatientDTO();
		if(patient!=null)
		{
			BeanUtils.copyProperties(patient, patientDTO);
		}
		return patientDTO;
	}



	//convert from DTO to Entity

	public  Doctor convertToDoctorEntity(DoctorDTO doctorDTO)
	{
		Doctor doctor=new Doctor();
		if(doctorDTO!=null)
		{
			BeanUtils.copyProperties(doctorDTO, doctor);
		}
	     return doctor;
	}

	//convert from Entity to DTO
	public DoctorDTO convertToDoctorDTO(Doctor doctor)
	{
		DoctorDTO doctorDTO=new DoctorDTO();
		if(doctor!=null)
		{
			BeanUtils.copyProperties(doctor, doctorDTO);
		}
		return doctorDTO;
	}
	
	public   User convertToUserEntity(User user)
	{
		User user1=new User();
		if(user1!=null)
		{
			BeanUtils.copyProperties(user1, user1);
		}
	     return user1;
	}

	
}

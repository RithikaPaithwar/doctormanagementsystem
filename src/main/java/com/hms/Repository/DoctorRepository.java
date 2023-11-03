package com.hms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	   
	}



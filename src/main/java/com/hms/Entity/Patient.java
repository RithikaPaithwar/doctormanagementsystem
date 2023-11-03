package com.hms.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=10)
     private int patient_id;
    @Column(length=20)
    private String patient_name;
    @Column(length=5)
    private String age;
    @Column(length=40)
    private String disease;
    @Column(length=20)
    private String gender;
 
    @JsonIgnore
 @ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="doctor_id")
@JsonIgnoreProperties
	private Doctor doctor;

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient(int patient_id, String patient_name, String age, String disease, String gender, Doctor doctor) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.age = age;
		this.disease = disease;
		this.gender = gender;
		this.doctor = doctor;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	
 

}

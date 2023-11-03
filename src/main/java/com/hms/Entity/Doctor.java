package com.hms.Entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="doctor")
public class Doctor {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private int doctor_id;
    @Column(length=20)
    @NotNull
    private String doctor_name;
    @Column(length=30)
    @NotNull
    private String specialization;
    
    @NotNull
    @Column(length=30)
    private String phone_number;
    
  //one doctor can check many patients
    @OneToMany(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY) 
	@JsonIgnoreProperties("doctor")
    List<Patient>patients ;

	public void setDoctor(List<Patient> patients2) {
		// TODO Auto-generated method stub
		
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Doctor(int doctor_id, @NotNull String doctor_name, @NotNull String specialization,
			@NotNull String phone_number, List<Patient> patients) {
		super();
		this.doctor_id = doctor_id;
		this.doctor_name = doctor_name;
		this.specialization = specialization;
		this.phone_number = phone_number;
		this.patients = patients;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
}
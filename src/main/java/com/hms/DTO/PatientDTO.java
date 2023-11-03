package com.hms.DTO;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.hms.Entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PatientDTO {
	@NotNull
	@Size(min=3,max=50,message = "Name should have min 2 to max 50 characters")
	private String id;
	
	@NotNull
	@Size(min=3,max=50,message = "Name should have min 2 to max 50 characters")
	private String name;
	
	
	@NotNull
	@Size(min=5,max=100,message = "Name should have min 2 to max 50 characters")
	private String age;
	//@NotNull
	
	@NotNull
	@Size(min=3,max=50,message = "Name should have min 2 to max 50 characters")
	private String disease;
	
	@NotNull
	@Size(min=3,max=50,message = "Name should have min 2 to max 50 characters")
	private String gender;
	
	private String phNo;
	
	private Doctor doctor;
	
}
	
	
	
	
package com.hms.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.Entity.User;
import com.hms.Service.UserService;
import com.hms.ServiceImpl.PatientServiceImpl;
import com.hms.ServiceImpl.UserServiceImp;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.persistence.*;
import javax.servlet.ServletException;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private UserServiceImp userServices;
	
	@Autowired
	private PatientServiceImpl pservice;
	
	@PostMapping("/login")
	public String validate(@RequestBody User user) throws ServletException
	{
		String jwtToken="";
		if(user.getUserName()==null || user.getPassword()==null)
		{
			throw new ServletException("Please fill in username and password");
		}
		String userName=user.getUserName();
		String userPassword=user.getPassword();
		user=userServices.login(userName, userPassword);
		
		if(user==null)
		{
			throw new ServletException("User not found");
		}
		jwtToken= Jwts.builder().setSubject(userName).claim("user",user.getUserName()).setIssuedAt(new Date()).
		signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		return jwtToken;
	}
	@GetMapping("/users")
	public List<User> getAllusers(){
		return  userServices.getAllusers();
		
	}
	
	@PostMapping("/assigndoctor/{did}/{pid}")
	public String assignDoctorToPatient(@PathVariable int did,@PathVariable int pid)
	{
		return pservice.assignDoctorToPatient(did,pid);
	}
}

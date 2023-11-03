package com.hms.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.Entity.User;
import com.hms.Repository.UserRepository;
import com.hms.Service.UserService;
import com.hms.Util.Converter;

@Service
public class UserServiceImp implements UserService
	{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public User login(String userName, String userPassword) 
	{
		 User user=userRepository.findByUserNameAndPassword(userName, userPassword);
		 return user;
	}

    @Override
	public List<User> getAllusers() {
		List<User> users=userRepository.findAll();
		return users;
	
    }
  }
package com.hms.Service;

import java.util.List;

import com.hms.Entity.User;

public interface UserService {
	
User login(String userName, String userPassword);
List<User> getAllusers();

}
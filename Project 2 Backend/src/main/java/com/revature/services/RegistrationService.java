package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class RegistrationService {
	
	UserDao uDao = new UserDao();
	
	public boolean findUserByUsername(String username) {
		if(uDao.findUserByUsername(username) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean findUserByEmail(String email) {
		if(uDao.findUserByEmail(email) != null){
			return true;
		} else {
			return false;
		}
	}
	
	public void registerUser(User u) {
		uDao.insertUser(u);
	}
	

}

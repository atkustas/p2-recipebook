package com.revature.services;

import com.revature.daos.UserDao;

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
	

}

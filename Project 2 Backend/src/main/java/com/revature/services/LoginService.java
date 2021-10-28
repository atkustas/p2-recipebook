package com.revature.services;

import com.revature.daos.UserDao;

public class LoginService {

	UserDao uDao = new UserDao();
<<<<<<< HEAD
=======
	
	public boolean login(String username, String password) {
		
		//check db for user based on username
		User user = uDao.userLogin(username);
		
		//check that username & password provided match credentials in db
		Boolean areEqual = username.equals(user.getUsername());
		Boolean areEqual2 = username.equals(user.getPassword());
		
		//if the credentials match, return true
		if(areEqual && areEqual2) {
			return true;
		}
		
		//if the credentials don't match, return false
		return false;
		
	}
	
>>>>>>> parent of a12cc23a7 (login functionality fixed)

	public boolean login(String username, String password) {
		return uDao.getCredentials(username, password);
	}
		
}
	


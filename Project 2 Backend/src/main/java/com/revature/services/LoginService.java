package com.revature.services;

import com.revature.daos.UserDao;

public class LoginService {

	UserDao uDao = new UserDao();

	public boolean login(String username, String password) {
		return uDao.getCredentials(username, password);
	}
		
}
	


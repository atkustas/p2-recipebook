package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class LoginService {

	Logger log = LogManager.getLogger(LoginService.class);
	UserDao uDao = new UserDao();
	
	public boolean login(String username, String password) {
		
		//check db for user based on username
		User user = uDao.userLogin(username);
		
		//check that username & password provided match credentials in db
		Boolean areEqual = username.equals(user.getUsername());
		Boolean areEqual2 = password.equals(user.getPassword());
		
		//if the credentials match, return true
		if(areEqual && areEqual2) {
			
			log.info(user.getFirstName() +" "+ user.getLastName() + " logged in with username: " +user.getUsername() + " and password: " +user.getPassword());
			
			return true;
		}
		
		//if the credentials don't match, return false
		log.info("Login attempt with invalid credentials username " +user.getUsername() + " and password: " +user.getPassword());
		return false;
		
	}
	

	public List<User> getUserByCredentials(String username, String password) {
		return uDao.getUserByCredentials(username, password);
	}
		
}
	


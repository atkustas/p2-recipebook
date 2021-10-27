package com.revature.controllers;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import com.revature.daos.UserDao;
import com.revature.models.User;
import com.revature.services.RegistrationService;

import io.javalin.http.Handler;

public class RegistrationController {
	
	RegistrationService rs = new RegistrationService();
	UserDao uDao = new UserDao();
	Logger log = LogManager.getLogger(RegistrationController.class);
		
	public Handler register = (ctx) -> {
		
		//convert incoming object to User object
		String body = ctx.body(); 
		Gson gson = new Gson();
		User userInput = gson.fromJson(body, User.class);
		
		//BIRTHDAY VALIDATION ADDED
		Calendar now = Calendar.getInstance();
		int year1 = now.get(Calendar.YEAR);
		int year2 = Integer.valueOf(userInput.getDob().substring(6));
		int month1 = now.get(Calendar.MONTH);
		int month2 = Integer.valueOf(userInput.getDob().substring(0,2));
     		int day1 = now.get(Calendar.DAY_OF_MONTH);
		int day2 = Integer.valueOf(userInput.getDob().substring(3,5));
		
		int age = year1 - year2;
		int month=month1-month2+1;
		int day=day1-day2;
		
		
		//check age is not less than 21 & that there is no existing username or email in database vs incoming info
		if(age<21 || (age==21 && month<0) || (age==21 && month==0 && day<0)) {
			ctx.status(403);
			ctx.result("You are under age!");
			log.info("Underage user attempted registration and was rejected.");
		} else if(rs.findUserByUsername(userInput.getUsername())) {
			ctx.status(406);
			ctx.result("Username already taken!");
			log.info("User attemped registration with an already taken username: " + userInput.getUsername() + ". Registration rejected.");
		} else if(rs.findUserByEmail(userInput.getEmail())) {
			ctx.status(409);
			ctx.result("Account with this email already exists.");
			log.info("User attempted registration with an email already in use: " + userInput.getEmail() + ". Registration failed.");

		} else {
			rs.registerUser(userInput);;
			ctx.status(201);
			ctx.result("New user added!");
			log.info("New user " + userInput.getFirstName() +" "+ userInput.getLastName() + " registered with site.");
		}

		};

	}

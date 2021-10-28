package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.RegistrationService;

import io.javalin.http.Handler;

public class RegistrationController {
	
	RegistrationService rs = new RegistrationService();
	
	public Handler register = (ctx) -> {
		
		//convert incoming object to User object
		String body = ctx.body(); 
		Gson gson = new Gson();
		User userInput = gson.fromJson(body, User.class);
		
		//check for existing username & email in database vs incoming info
		if(rs.findUserByUsername(userInput.getUsername())) {
			ctx.status(406);
			ctx.result("Username already taken!");
		} else if(rs.findUserByEmail(userInput.getEmail())) {
			ctx.status(409);
			ctx.result("Account with this email already exists.");
		} else {
			ctx.status(201);
			ctx.result("New user added!");
		}
		//STILL NEED TO ADD BIRTHDAY VALIDATION

		};

	}

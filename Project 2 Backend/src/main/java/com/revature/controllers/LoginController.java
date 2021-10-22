package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.utils.JwtUtil;

import io.javalin.http.Handler;

public class LoginController {
	
	LoginService ls = new LoginService();

	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body(); 
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); 
		
		
		if(ls.login(LDTO.getUsername(), LDTO.getPassword())) { 
			
			String jwt = JwtUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			
			ctx.req.getSession(); 
			ctx.status(200);
			
			
			ctx.result("Successful login! JWT is: " + jwt);
			
		} else { 
			ctx.status(401); 
			ctx.result("Login failed!");
			
		}
		
		
	};
	
	public Handler returnuser = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
			
			//get user object based on credentials sent in
			List<User> user = ls.getUserByCredentials(LDTO.getUsername(), LDTO.getPassword());
			
			//convert Java user to JSON
			String JSONuser = gson.toJson(user);
			
			//send back user
			ctx.result(JSONuser);
			
			}
		
	};

}

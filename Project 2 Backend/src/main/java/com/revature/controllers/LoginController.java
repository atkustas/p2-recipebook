package com.revature.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.LoginPackage;
import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.utils.JwtUtil;

import io.javalin.http.Handler;

public class LoginController {
	
	Logger log = LogManager.getLogger(LoginController.class);
	LoginService ls = new LoginService();

	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body(); 
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); 
		
		LoginPackage lp = new LoginPackage();
		
		
		
		if(ls.login(LDTO.getUsername(), LDTO.getPassword())) { 
			
			User u = new User();
			String jwt = JwtUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			
			ctx.req.getSession(); 
			ctx.status(200);
			
			List<User> user = ls.getUserByCredentials(LDTO.getUsername(), LDTO.getPassword());
			
			for(User x : user) {
				u = x;
			}
			
			lp.setUser(u);
			lp.setJwt(jwt);
			
			String packageJSON = gson.toJson(lp);
			
			ctx.result(packageJSON);
			
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
			
//			User u = new User();
//			
//			for(User x : user) {
//				u = x;
//			}
			
			//convert Java user to JSON
			String JSONuser = gson.toJson(user);
			
			log.info("Sent user back to frontend");
			
			//send back user
			ctx.result(JSONuser);
			
			}
		
	};

}

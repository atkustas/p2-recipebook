package com.revature.controllers;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.Cocktail;
import com.revature.models.Review;
import com.revature.models.ReviewDTO;
import com.revature.models.User;
import com.revature.services.ReviewService;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class ReviewController {
	ReviewService rs=new ReviewService();
	UserService us=new UserService();
	public Handler addreview = (ctx) -> {
		HttpSession session = ctx.req.getSession(false);
		if(session != null) {
			String body = ctx.body();
			Gson gson = new Gson();
			
			ReviewDTO rDTO = gson.fromJson(body, ReviewDTO.class);
			Cocktail rDrink = rs.getDrinkById(rDTO.getDrink());
			User rUser = rs.getUserById(rDTO.getUser_id());

			Calendar now = Calendar.getInstance();
			String currentDate=String.valueOf(now.get(Calendar.MONTH)+1)+"/"+String.valueOf(now.get(Calendar.DAY_OF_MONTH))+"/"+String.valueOf(now.get(Calendar.YEAR));
			Review r = new Review(rUser,rDrink,rDTO.getReview(), currentDate);
			rs.addReview(r);
			
			ctx.status(200);
			
		} else {
			ctx.status(403);
		}
	};
	
}

package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Cocktail;
import com.revature.models.Favorite;
import com.revature.models.Review;
import com.revature.models.ReviewDTO;
import com.revature.models.User;
import com.revature.services.FavoriteService;
import com.revature.services.ReviewService;

import io.javalin.http.Handler;

public class FavoriteController {
	
	ReviewService rs = new ReviewService();
	FavoriteService fs = new FavoriteService();
	
	public Handler addfavorite = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			
				String body = ctx.body();
				Gson gson = new Gson();
				
				ReviewDTO rDTO = gson.fromJson(body, ReviewDTO.class);
				Cocktail rDrink = rs.getDrinkById(rDTO.getDrink());
				User rUser = rs.getUserById(rDTO.getUser_id());
				
				Favorite r = new Favorite(rUser, rDrink);
				
				fs.addFavorite(r);
				
				ctx.status(200);
				
			} else {
				ctx.status(403);
			}
		};
		
		
		
	public Handler userfavs = (ctx) -> {
			
		if(ctx.req.getSession(false) != null) {
				
			User user = ctx.bodyAsClass(User.class);
				
			List<Favorite> userFavs = fs.viewFavorites(user);
				
			Gson gson = new Gson();
				
			String favorites = gson.toJson(userFavs);
				
			ctx.result(favorites);
			ctx.status(200);
				
		} else {
			ctx.status(403);
		}
			
	};

}

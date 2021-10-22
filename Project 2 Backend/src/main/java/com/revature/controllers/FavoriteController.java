package com.revature.controllers;

import com.revature.services.FavoriteService;

import io.javalin.http.Handler;

public class FavoriteController {
	
	ReviewService rs = new ReviewService();
	FavoriteService fs = new FavoriteService();
	
	public Handler addFavorite = (ctx) -> {
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

}
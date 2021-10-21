package com.revature.controllers;

import com.revature.services.FavoriteService;

import io.javalin.http.Handler;

public class FavoriteController {
	
	FavoriteService fs = new FavoriteService();
	
	public Handler addFavorite = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
			String drink = ctx.body();
			
			// fs.addFavorite(u, drink);
			
			
		}
		
		
	};

}

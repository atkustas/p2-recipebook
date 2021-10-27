package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Cocktail;
import com.revature.models.Favorite;
import com.revature.models.FavoriteDTO;
import com.revature.models.ReviewDTO;
import com.revature.models.User;
import com.revature.services.CocktailService;
import com.revature.services.FavoriteService;
import com.revature.services.ReviewService;

import io.javalin.http.Handler;

public class FavoriteController {
	
	ReviewService rs = new ReviewService();
	FavoriteService fs = new FavoriteService();
	CocktailService cs = new CocktailService();
		
		public Handler addfavorite = (ctx) -> {
			
			if(ctx.req.getSession(false) != null) {
				
					String body = ctx.body();
					Gson gson = new Gson();
					
					FavoriteDTO fDTO = gson.fromJson(body, FavoriteDTO.class);
					
					Cocktail c = new Cocktail(fDTO.getDrink());
					cs.addCocktail(c);
					
					Cocktail rDrink = rs.findDrinkByDrinkName(fDTO.getDrink());
					User rUser = rs.getUserById(fDTO.getUser_id());
					
					Favorite r = new Favorite(rUser, rDrink);
					
					fs.addFavorite(r);
					
					ctx.status(200);
					
				} else {
					ctx.status(403);
				}
			};
		
		
		
	public Handler userfavs = (ctx) -> {
			
		if(ctx.req.getSession(false) != null) {
				
			FavoriteDTO f = ctx.bodyAsClass(FavoriteDTO.class);
				
			List<Favorite> userFavs = fs.viewFavorites(f.getUser_id());
				
			Gson gson = new Gson();
				
			String favorites = gson.toJson(userFavs);
				
			ctx.result(favorites);
			ctx.status(200);
				
		} else {
			ctx.status(403);
		}
			
	};
	
	//before refactor
	public Handler addfav = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
				String body = ctx.body();
				Gson gson = new Gson();
				
				ReviewDTO rDTO = gson.fromJson(body, ReviewDTO.class);
				Cocktail rDrink = rs.findDrinkByDrinkName(rDTO.getDrink());
				User rUser = rs.getUserById(rDTO.getUser_id());
				
				Favorite r = new Favorite(rUser, rDrink);
				
				fs.addFavorite(r);
				
				ctx.status(200);
				
			} else {
				ctx.status(403);
			}
		};

}

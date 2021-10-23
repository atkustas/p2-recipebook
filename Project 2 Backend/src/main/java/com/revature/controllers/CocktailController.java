package com.revature.controllers;

import com.revature.models.Cocktail;
import com.revature.services.CocktailService;

import io.javalin.http.Handler;

public class CocktailController {
	
	CocktailService cs = new CocktailService();
	
	public Handler addcocktail = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) {
			
			Cocktail c = ctx.bodyAsClass(Cocktail.class);
			
			cs.addCocktail(c);
			
		}else {
			ctx.status(403);
		}
		
	};

}

package com.revature.services;

import com.revature.daos.CocktailDao;
import com.revature.models.Cocktail;

public class CocktailService {
	
	CocktailDao cd = new CocktailDao();
	
	public void addCocktail(Cocktail c) {
		cd.addCocktail(c);
	}

}

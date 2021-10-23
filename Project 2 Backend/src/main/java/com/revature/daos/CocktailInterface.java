package com.revature.daos;

import java.util.List;

import com.revature.models.Cocktail;

public interface CocktailInterface {
	
	public Cocktail findDrinkById(int id);
	
	public void addCocktail(Cocktail c);
	
	public List<Cocktail> getAllCocktails();
	
	public List<Cocktail> getCocktailByName(String name);

	Cocktail findDrinkByDrinkName(String drink);

}

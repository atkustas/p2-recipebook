package com.revature.daos;

import com.revature.models.Cocktail;
import com.revature.models.User;

public interface FavoriteInterface {
	
	public void addFavorite(User u, Cocktail drink);
	
	public void deleteFavoriteById(int id);

}

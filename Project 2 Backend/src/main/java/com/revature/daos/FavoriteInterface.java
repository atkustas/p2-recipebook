package com.revature.daos;

import com.revature.models.Cocktail;
import com.revature.models.User;

public interface FavoriteInterface {
	
	public void addFavorite(Favorite f);
	
	public void deleteFavoriteById(int id);

}

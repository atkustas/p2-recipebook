package com.revature.daos;

import com.revature.models.Favorite;

public interface FavoriteInterface {
	
	public void addFavorite(Favorite f);
	
	public void deleteFavoriteById(int id);

}

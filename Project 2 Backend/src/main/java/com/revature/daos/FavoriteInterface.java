package com.revature.daos;

import java.util.List;

import com.revature.models.Favorite;
import com.revature.models.User;

public interface FavoriteInterface {
	
	public void addFavorite(Favorite f);
	
	public void deleteFavoriteById(int id);
	
	public List<Favorite> viewFavorites(int u);

}

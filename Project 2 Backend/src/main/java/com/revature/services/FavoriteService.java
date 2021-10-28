package com.revature.services;

import com.revature.daos.FavoriteDao;
import com.revature.models.Cocktail;
import com.revature.models.User;

public class FavoriteService {
	
	FavoriteDao fd = new FavoriteDao();
	
	public void addFavorite(Favorite f) {
		fd.addFavorite(f);
	}

}

package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.FavoriteDao;
import com.revature.models.Favorite;
import com.revature.models.User;

public class FavoriteService {
	
	Logger log = LogManager.getLogger(FavoriteService.class);
	FavoriteDao fd = new FavoriteDao();
	
	public void addFavorite(Favorite f) {
		fd.addFavorite(f);
		
		log.info("User " + f.getUser_list() +" added drink " + f.getDrink_id() + " to their Favorites.");
	}
	
	public List<Favorite> viewFavorites(int u) {
		return fd.viewFavorites(u);
	}

}

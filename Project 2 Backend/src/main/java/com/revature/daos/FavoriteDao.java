package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Cocktail;
import com.revature.models.Favorite;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class FavoriteDao implements FavoriteInterface {

	@Override
	public void addFavorite(User u, Cocktail drink) {

		Favorite f = new Favorite(u, drink);
		
		try(Session ses = HibernateUtil.getSession()){
			
			ses.save(f);
			
		} catch(Exception e) {
			System.out.println("Favorite addition failed.");
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public void deleteFavoriteById(int id) {

		
		
	}
	
	

}

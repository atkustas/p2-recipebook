package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Cocktail;
import com.revature.models.Favorite;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class FavoriteDao implements FavoriteInterface {

	@Override
	public void addFavorite(Favorite f) {

		try(Session ses = HibernateUtil.getSession()){
			
//			Favorite existingFav = null;
//			
//			List<Favorite> favoriteList = viewFavorites(f.getUser_list().getUser_id());
		
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
	
	@SuppressWarnings("unchecked")
	public List<Favorite> viewFavorites(int u) {
		
		Session ses = HibernateUtil.getSession();
		
		List<Favorite> userFavs = ses.createQuery("FROM Favorite WHERE user_list = " + u).list();
		
		for(Favorite f : userFavs) {
			System.out.println(f);
		}
		
		HibernateUtil.closeSession();
		
		return userFavs;
		
	}
	

}

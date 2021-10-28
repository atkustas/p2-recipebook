package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Cocktail;
import com.revature.utils.HibernateUtil;

public class CocktailDao {

	public Cocktail findDrinkById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Cocktail drink = ses.get(Cocktail.class, id);
		
		HibernateUtil.closeSession();
		
		return drink;
	}

	
}

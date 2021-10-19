package com.revature.daos;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.revature.models.Cocktail;
import com.revature.utils.HibernateUtil;

public class CocktailDao implements CocktailInterface{

	public Cocktail findDrinkById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Cocktail drink = ses.get(Cocktail.class, id);
		
		HibernateUtil.closeSession();
		
		return drink;
	}

	@Override
	public void addCocktail(Cocktail c) {
	
		try(Session ses = HibernateUtil.getSession()){
			
			ses.save(c);

			
		} catch(Exception e) {
			System.out.println("Cocktail addition failed.");
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cocktail> getCocktailByName(String drink) {

		Session ses = HibernateUtil.getSession();
		
		List<Cocktail> d = ses.createQuery("FROM Cocktail WHERE drink = " + drink).list();
		
		HibernateUtil.closeSession();
		
		return d;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cocktail> getAllCocktails() {
		
		Session ses = HibernateUtil.getSession();
		
		List<Cocktail> cocktailList = ses.createQuery("FROM Cocktail").list();
		HibernateUtil.closeSession();
		
		//debugging
		for(Cocktail c : cocktailList) {
			System.out.println("Inside getAllCocktails");
			System.out.println(c);
		}
			
		return cocktailList;
	}
	
	

	
}

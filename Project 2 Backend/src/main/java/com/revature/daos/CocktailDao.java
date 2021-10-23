package com.revature.daos;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import com.revature.utils.HibernateUtil;
import com.revature.models.Cocktail;

//GOOD VERSION OF COCKTAILDAO

public class CocktailDao implements CocktailInterface{
	Logger log = LogManager.getLogger(CocktailDao.class);

	public Cocktail findDrinkById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Cocktail drink = ses.get(Cocktail.class, id);
		
		HibernateUtil.closeSession();
		
		return drink;
	}

	@Override
	public void addCocktail(Cocktail c) {
	
		try(Session ses = HibernateUtil.getSession()){
		
		Cocktail existingDrink = null;
		
		List<Cocktail> cocktailList = getAllCocktails();
		
		for(Cocktail d : cocktailList) {
			if(d.getDrink().equalsIgnoreCase(c.getDrink())) {
				existingDrink = c;
			}
		}
		
		//debugging
		System.out.println(existingDrink);
		
		if(existingDrink == null) {
			Session ses2 = HibernateUtil.getSession();
			ses2.save(c);
			log.info("New cocktail added to database: " + c.getDrink());
			HibernateUtil.closeSession();
		}
		
			
		} catch(Exception e) {
			System.out.println("Cocktail addition failed.");
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public Cocktail findDrinkByDrinkName(String drink) {
		Session ses = HibernateUtil.getSession();
		Cocktail d = (Cocktail) ses.createQuery("FROM Cocktail WHERE drink = \'" + drink + "\'").uniqueResult();
		HibernateUtil.closeSession();
		return d;
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

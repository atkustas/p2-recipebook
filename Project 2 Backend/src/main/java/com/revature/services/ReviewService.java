package com.revature.services;

import com.revature.daos.CocktailDao;
import com.revature.daos.ReviewDao;
import com.revature.daos.UserDao;
import com.revature.models.Cocktail;
import com.revature.models.Review;
import com.revature.models.User;

public class ReviewService {
	
	ReviewDao rDao=new ReviewDao();
	CocktailDao cDao=new CocktailDao();
	UserDao uDao = new UserDao();

	
	public Cocktail getDrinkById(int id) {
		Cocktail drink = cDao.findDrinkById(id);
		return drink;
	}

	
	public User getUserById(int id) {
		User rev_author = uDao.findUserByUserid(id);
		return rev_author;
	}

	
	public void addReview(Review r) {
		rDao.addReview(r);
	}
	

	
}

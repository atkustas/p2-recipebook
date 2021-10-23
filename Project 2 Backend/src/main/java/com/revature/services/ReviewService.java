package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	Logger log = LogManager.getLogger(ReviewService.class);

	public Cocktail findDrinkByDrinkName(String drink) {
		Cocktail d = cDao.findDrinkByDrinkName(drink);
		return d;
	}

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
		log.info("Review submitted by User " + r.getRev_author() + " for Cocktail " + r.getDrink());
		log.info("Review: " + r.getReview());
	}
	
	public List<Review> allReviews(){
		return rDao.getAllReviews();
	}
	
	public List<Review> reviewsByUser(User user){
		log.info("Cocktail reviews viewed for User " + user.getUser_id() +":" + user.getFirstName() + " " + user.getLastName());
		return rDao.reviewsByUser(user);
	}
	
	public List<Review> reviewsByDrink(String drink){
		log.info("Reviews for " + drink + " viewed.");
		return rDao.getReviewsByDrink(drink);
	}
	

	
}

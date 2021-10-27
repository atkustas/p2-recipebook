package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Cocktail;
import com.revature.models.Review;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class ReviewDao implements ReviewInterface {

	@Override
	public void addReview(Review r) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.save(r);
		
		HibernateUtil.closeSession();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getReviewsByDrink(String cocktail) {
		
		Session ses = HibernateUtil.getSession();
		
			List<Cocktail> c = ses.createQuery("FROM Cocktail WHERE drink = " +"'"+cocktail+"'").list();
			
			for(Cocktail test : c) {
				System.out.println(test);
			}
			
			Cocktail drink = null;
			
			for(Cocktail d : c) {
				drink = d;
			}
			
			List<Review> drinkReviews= ses.createQuery("FROM Review WHERE drink = " + drink.getDrink_id()).list();
			
			//testing
			for(Review d : drinkReviews) {
				System.out.println(d);
			}
			
		HibernateUtil.closeSession();
		
		return drinkReviews;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getAllReviews() {
		
		Session ses = HibernateUtil.getSession();
		
		List<Review> allReviews = ses.createQuery("FROM Review").list();
		
		
		//debugging
		for(Review r : allReviews) {
			System.out.println(r);
		}
		
		HibernateUtil.closeSession();
		
		return allReviews;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> reviewsByUser(User u) {

		Session ses = HibernateUtil.getSession();
		
		//debugging
		System.out.println("Inside reviewsByUser");
		System.out.println(u);
		
		List<Review> userReviews = ses.createQuery("FROM Review WHERE rev_author = " + u.getUser_id()).list();
		
		//debugging
		for(Review r : userReviews) {
			System.out.println(r);
		}
		
		HibernateUtil.closeSession();
		
		return userReviews;
	}

	
}

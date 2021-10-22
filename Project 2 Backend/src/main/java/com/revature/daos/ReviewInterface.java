package com.revature.daos;

import java.util.List;

import com.revature.models.Cocktail;
import com.revature.models.Review;
import com.revature.models.User;

public interface ReviewInterface {
	
	public void addReview(Review r);
	
	public List<Review> getReviewsByDrink(String cocktail);
	
	public List<Review> getAllReviews();
	
	public List<Review> reviewsByUser(User u);
}

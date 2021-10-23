package com.revature.models;

public class ReviewDTO {

	private String review;
	private String drink;
	private int user_id;
	private int drink_id;
	

	public int getDrink_id() {
		return drink_id;
	}


	public void setDrink_id(int drink_id) {
		this.drink_id = drink_id;
	}


	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReviewDTO(String review, String drink, int user_id,int drink_id) {
		super();
		this.review = review;
		this.drink = drink;
		this.user_id = user_id;
		this.drink_id = drink_id;

	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public String getDrink() {
		return drink;
	}


	public void setDrink(String drink) {
		this.drink = drink;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}




	

	
}

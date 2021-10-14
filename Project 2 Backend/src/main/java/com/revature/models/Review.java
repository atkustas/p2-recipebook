package com.revature.models;

public class Review {
	
	private int rev_id;
	private int user_id;
	private int drink_id;
	private String review;
	private String date;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args
	public Review(int rev_id, int user_id, int drink_id, String review, String date) {
		super();
		this.rev_id = rev_id;
		this.user_id = user_id;
		this.drink_id = drink_id;
		this.review = review;
		this.date = date;
	}

	//no-id
	public Review(int user_id, int drink_id, String review, String date) {
		super();
		this.user_id = user_id;
		this.drink_id = drink_id;
		this.review = review;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Review [rev_id=" + rev_id + ", user_id=" + user_id + ", drink_id=" + drink_id + ", review=" + review
				+ ", date=" + date + "]";
	}

	public int getRev_id() {
		return rev_id;
	}

	public void setRev_id(int rev_id) {
		this.rev_id = rev_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getDrink_id() {
		return drink_id;
	}

	public void setDrink_id(int drink_id) {
		this.drink_id = drink_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + drink_id;
		result = prime * result + rev_id;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (drink_id != other.drink_id)
			return false;
		if (rev_id != other.rev_id)
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
	
	
	
	
	

}

package com.revature.models;

public class Review {
	
	private int rev_id;
	private int user_id;
	private int drink_id;
	private String review;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args
	public Review(int rev_id, int user_id, int drink_id, String review) {
		super();
		this.rev_id = rev_id;
		this.user_id = user_id;
		this.drink_id = drink_id;
		this.review = review;
	}

	//no-id
	public Review(int user_id, int drink_id, String review) {
		super();
		this.user_id = user_id;
		this.drink_id = drink_id;
		this.review = review;
	}

	@Override
	public String toString() {
		return "Review [rev_id=" + rev_id + ", user_id=" + user_id + ", drink_id=" + drink_id + ", review=" + review
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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

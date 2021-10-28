package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rev_id")
	private int rev_id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "rev_author", referencedColumnName= "user_id")
	private User rev_author;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "drink", referencedColumnName = "drink_id")
	private Cocktail drink;
	
	
	private String review;
	private String date;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args
	public Review(int rev_id, User rev_author, Cocktail drink, String review, String date) {
		super();
		this.rev_id = rev_id;
		this.rev_author = rev_author;
		this.drink = drink;
		this.review = review;
		this.date = date;
	}

	//no-id
	public Review(User rev_author, Cocktail drink, String review, String date) {
		super();
		this.rev_author = rev_author;
		this.drink = drink;
		this.review = review;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Review [rev_id=" + rev_id + ", rev_author=" + rev_author + ", drink=" + drink + ", review=" + review
				+ ", date=" + date + "]";
	}

	public int getRev_id() {
		return rev_id;
	}

	public void setRev_id(int rev_id) {
		this.rev_id = rev_id;
	}

	public User getRev_author() {
		return rev_author;
	}

	public void setRev_author(User rev_author) {
		this.rev_author = rev_author;
	}

	public Cocktail getDrink() {
		return drink;
	}

	public void setDrink(Cocktail drink) {
		this.drink = drink;
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
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
		result = prime * result + ((rev_author == null) ? 0 : rev_author.hashCode());
		result = prime * result + rev_id;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
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
		if (drink == null) {
			if (other.drink != null)
				return false;
		} else if (!drink.equals(other.drink))
			return false;
		if (rev_author == null) {
			if (other.rev_author != null)
				return false;
		} else if (!rev_author.equals(other.rev_author))
			return false;
		if (rev_id != other.rev_id)
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		return true;
	}

	

}

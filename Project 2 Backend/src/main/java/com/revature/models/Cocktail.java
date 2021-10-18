package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cocktails")
public class Cocktail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drink_id")
	private int drink_id;
	
	private String drink;
	
	public Cocktail() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args
	public Cocktail(int drink_id, String drink) {
		super();
		this.drink_id = drink_id;
		this.drink = drink;
	}

	//no-id
	public Cocktail(String drink) {
		super();
		this.drink = drink;
	}

	@Override
	public String toString() {
		return "Cocktail [drink_id=" + drink_id + ", drink=" + drink + "]";
	}

	public int getDrink_id() {
		return drink_id;
	}

	public void setDrink_id(int drink_id) {
		this.drink_id = drink_id;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
		result = prime * result + drink_id;
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
		Cocktail other = (Cocktail) obj;
		if (drink == null) {
			if (other.drink != null)
				return false;
		} else if (!drink.equals(other.drink))
			return false;
		if (drink_id != other.drink_id)
			return false;
		return true;
	}
	
	
	
	

}

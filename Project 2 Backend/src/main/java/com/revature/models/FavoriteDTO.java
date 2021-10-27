package com.revature.models;

public class FavoriteDTO {
	
	private String drink;
	private int user_id;
	
	public FavoriteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FavoriteDTO(String drink, int user_id) {
		super();
		this.drink = drink;
		this.user_id = user_id;
	}

	public FavoriteDTO(int user_id) {
		super();
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "FavoriteDTO [drink=" + drink + ", user_id=" + user_id + "]";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
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
		FavoriteDTO other = (FavoriteDTO) obj;
		if (drink == null) {
			if (other.drink != null)
				return false;
		} else if (!drink.equals(other.drink))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
	
	

}

package com.revature.models;

public class Favorite {
	
	private int entry_id;
	private int user_id;
	private int drink_id;
	
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args
	public Favorite(int entry_id, int user_id, int drink_id) {
		super();
		this.entry_id = entry_id;
		this.user_id = user_id;
		this.drink_id = drink_id;
	}
	
	
	//no-id
	public Favorite(int user_id, int drink_id) {
		super();
		this.user_id = user_id;
		this.drink_id = drink_id;
	}

	@Override
	public String toString() {
		return "Favorite [entry_id=" + entry_id + ", user_id=" + user_id + ", drink_id=" + drink_id + "]";
	}

	public int getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(int entry_id) {
		this.entry_id = entry_id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + drink_id;
		result = prime * result + entry_id;
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
		Favorite other = (Favorite) obj;
		if (drink_id != other.drink_id)
			return false;
		if (entry_id != other.entry_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
	
	

}

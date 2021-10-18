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
@Table(name = "favorites")
public class Favorite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entry_id")
	private int entry_id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_list", referencedColumnName = "user_id")
	private User user_list;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "drink_id", referencedColumnName = "drink_id")
	private Cocktail drink_id;
	
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(int entry_id, User user_list, Cocktail drink_id) {
		super();
		this.entry_id = entry_id;
		this.user_list = user_list;
		this.drink_id = drink_id;
	}

	public Favorite(User user_list, Cocktail drink_id) {
		super();
		this.user_list = user_list;
		this.drink_id = drink_id;
	}

	@Override
	public String toString() {
		return "Favorite [entry_id=" + entry_id + ", user_list=" + user_list + ", drink_id=" + drink_id + "]";
	}

	public int getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(int entry_id) {
		this.entry_id = entry_id;
	}

	public User getUser_list() {
		return user_list;
	}

	public void setUser_list(User user_list) {
		this.user_list = user_list;
	}

	public Cocktail getDrink_id() {
		return drink_id;
	}

	public void setDrink_id(Cocktail drink_id) {
		this.drink_id = drink_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drink_id == null) ? 0 : drink_id.hashCode());
		result = prime * result + entry_id;
		result = prime * result + ((user_list == null) ? 0 : user_list.hashCode());
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
		if (drink_id == null) {
			if (other.drink_id != null)
				return false;
		} else if (!drink_id.equals(other.drink_id))
			return false;
		if (entry_id != other.entry_id)
			return false;
		if (user_list == null) {
			if (other.user_list != null)
				return false;
		} else if (!user_list.equals(other.user_list))
			return false;
		return true;
	}

	

}

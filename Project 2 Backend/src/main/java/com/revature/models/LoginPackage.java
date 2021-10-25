package com.revature.models;

public class LoginPackage {
	
	private User user;
	private String jwt;
	
	public LoginPackage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginPackage(User user, String jwt) {
		super();
		this.user = user;
		this.jwt = jwt;
	}

	@Override
	public String toString() {
		return "LoginPackage [user=" + user + ", jwt=" + jwt + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jwt == null) ? 0 : jwt.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		LoginPackage other = (LoginPackage) obj;
		if (jwt == null) {
			if (other.jwt != null)
				return false;
		} else if (!jwt.equals(other.jwt))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	

}

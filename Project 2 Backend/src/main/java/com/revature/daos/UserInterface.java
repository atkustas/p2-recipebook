package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserInterface {
	
	public void insertUser(User input);
	
	public User userLogin(String username);
	
	public User findUserByUserid(int userid);

	public User findUserByUsername(String username);
	
	public User findUserByEmail(String email);
	
	public List<User> findAllUsers();

	public List<User> getUserByCredentials(String username, String password);
}

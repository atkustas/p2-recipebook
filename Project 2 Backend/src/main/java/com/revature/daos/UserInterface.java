package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserInterface {
	
	public void insertUser(User input);
	
	public User userLogin(String username);
	
<<<<<<< HEAD
	public User findUserByUserid(int userid);

=======
>>>>>>> d4ef34dcf336f70fe99e628ed2c751d9f5df5b2c
	public User findUserByUsername(String username);
	
	public User findUserByEmail(String email);
	
	public List<User> findAllUsers();

	public List<User> getUserByCredentials(String username, String password);
}

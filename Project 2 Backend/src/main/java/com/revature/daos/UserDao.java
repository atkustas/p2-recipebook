package com.revature.daos;

import java.util.List;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDao implements UserInterface {
	
	@Override
	public void insertUser(User userInput) {
		
		try(Session ses = HibernateUtil.getSession()){
			
			ses.save(userInput);

			
		} catch(Exception e) {
			System.out.println("User addition failed.");
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		
	}
	
	@Override
	public User userLogin(String username) {
		
		User temp = new User();
		
		temp = findUserByUsername(username);
		int tempId = temp.getUser_id();
		
		//debugging
		System.out.println("Inside userLogin");
		System.out.println(username);
		
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, tempId);
		
		//debugging
		System.out.println("Inside userLogin");
		System.out.println(user.toString());
		
		HibernateUtil.closeSession();
		
		return user;
		
	}

	@Override
	public User findUserByUserid(int userid) {
		Session ses = HibernateUtil.getSession();
		
		User user = ses.get(User.class, userid);
		
		HibernateUtil.closeSession();
		
		return user;
	}

	@Override
	public User findUserByUsername(String username) {
		
		int tempId = 0;
		
		//retrieve users from database
		List<User> allUser = findAllUsers();
		
		//search user list for a user with matching username
		for (User u : allUser) {
			System.out.println("Inside findUserByUsername");
			System.out.println(u);
			Boolean areEqual = 	username.equals(u.getUsername());
			if(areEqual) {
				User temp = u;
				tempId = temp.getUser_id();
				
			}
		}
		
		//search db for User object based on id if it found a match on username
		Session ses = HibernateUtil.getSession();

		User user = ses.get(User.class, tempId);

		HibernateUtil.closeSession();

		return user;
	}
	
	@Override
	public User findUserByEmail(String email) {
		
		int tempId = 0;
		
		//retrieve users from database
		List<User> allUser = findAllUsers();
		
		//search user list for a user with matching username
		for (User u : allUser) {
			System.out.println("Inside findUserByEmail");
			System.out.println(u);
			Boolean testEmailEquality = email.equals(u.getEmail());
			if(testEmailEquality) {
			
				User existingUser = u;
				tempId = existingUser.getUser_id();
				
			}
		}
		
		//search db for User object based on id if it found a match on username
		Session ses = HibernateUtil.getSession();

		User existingUser = ses.get(User.class, tempId);

		HibernateUtil.closeSession();

		return existingUser;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {

		Session ses = HibernateUtil.getSession();
			
		List<User> listOfUsers = ses.createQuery("FROM User").list();
		
		
		//debugging
		for(User u : listOfUsers) {
			System.out.println("Inside findAllUsers");
			System.out.println(u);
		}
			
		HibernateUtil.closeSession();
		
		return listOfUsers;
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByCredentials(String username, String password) {
		
		Session ses = HibernateUtil.getSession();
			
		List<User> user = ses.createQuery("FROM User WHERE username = '" + username + "' AND password = '" + password + "'").list();
		
		HibernateUtil.closeSession();
		
		return user;

	}

}

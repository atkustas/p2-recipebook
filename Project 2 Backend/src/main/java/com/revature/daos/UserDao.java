package com.revature.daos;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> parent of 0fc0ec34e (Registration functionality)
=======
>>>>>>> parent of 9fad7ceed (insert user, login functionality almost done)
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class UserDao implements UserDaoInterface {

	@Override
	public boolean getCredentials(String username, String password) {
		try(Session ses = HibernateUtil.getSession()){
			
			User user = (User) ses.createQuery("FROM User WHERE username = \'" + username + "\'" +" AND "+ "password = \'" + password + "\'").uniqueResult();
			
			if (user != null) {
				
				HibernateUtil.closeSession();
				return true;
			}
<<<<<<< HEAD
<<<<<<< HEAD
			
			HibernateUtil.closeSession();
			return false;
		
		} catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Unable to access database for login");
=======
		}
		
		//search db for User object based on id if it found a match on username
		Session ses = HibernateUtil.getSession();

		User user = ses.get(User.class, tempId);
		//System.out.println(user);

		HibernateUtil.closeSession();


		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {

		Session ses = HibernateUtil.getSession();
=======
>>>>>>> parent of 9fad7ceed (insert user, login functionality almost done)
			
			HibernateUtil.closeSession();
			return false;
		
<<<<<<< HEAD
		//debugging
		for(User u : listOfUsers) {
			System.out.println("Inside findAllUsers");
			System.out.println(u);
>>>>>>> parent of 0fc0ec34e (Registration functionality)
=======
		} catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Unable to access database for login");
>>>>>>> parent of 9fad7ceed (insert user, login functionality almost done)
		}
		return false;
	}
}

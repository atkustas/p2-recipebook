package com.revature.daos;

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
			
			HibernateUtil.closeSession();
			return false;
		
		} catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Unable to access database for login");
		}
		return false;
	}
}

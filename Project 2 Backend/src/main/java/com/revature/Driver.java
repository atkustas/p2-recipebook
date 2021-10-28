package com.revature;

<<<<<<< HEAD
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
=======
import org.hibernate.HibernateException;
import org.hibernate.Session;

<<<<<<< HEAD
import com.revature.controllers.LoginController;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.revature.daos.UserDao;
import com.revature.models.User;
>>>>>>> parent of 0fc0ec34e (Registration functionality)
=======
>>>>>>> parent of 9fad7ceed (insert user, login functionality almost done)
=======
>>>>>>> parent of 073a79bc0 (LoginDTO and LoginController service created)
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		System.out.println("%%%%% MAIN LOADED %%%%%");
		
		//open connection
		try (Session ses = HibernateUtil.getSession()) {

			System.out.println("Hello you have a Connection to your DB with Hibernate!");
			HibernateUtil.closeSession();// could leave this connection test in, close the session within the try/catch
		} catch (HibernateException e) {
			System.out.println("DB connection has failed!!");
		}

		
		//get server up
		Javalin app = Javalin.create(

				config -> {
					config.enableCorsForAllOrigins();// allows the sever to process JS request from anywhere
				}

		).start(8090);
<<<<<<< HEAD
		
		//Added by Mesfin
		app.post("/login", lc.loginHandler);
<<<<<<< HEAD
<<<<<<< HEAD
=======
		
		
		//add some users
		User u1 = new User("test@gmail.com", "username", "password", "Billy", "Bob", "10/15/2021");
		UserDao uDao = new UserDao();
		
		uDao.insertUser(u1);
>>>>>>> parent of 0fc0ec34e (Registration functionality)
=======
>>>>>>> parent of 9fad7ceed (insert user, login functionality almost done)

>>>>>>> parent of 171a02461 (fixed reviewsByUser, bug in reviewsByDrink)
=======
>>>>>>> parent of 073a79bc0 (LoginDTO and LoginController service created)

	}

}

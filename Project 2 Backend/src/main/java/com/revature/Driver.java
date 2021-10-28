package com.revature;

<<<<<<< HEAD
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
=======
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.controllers.LoginController;
<<<<<<< HEAD
=======
import com.revature.daos.UserDao;
import com.revature.models.User;
>>>>>>> parent of 0fc0ec34e (Registration functionality)
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		System.out.println("%%%%% MAIN LOADED %%%%%");
		LoginController lc = new LoginController(); 
		
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
		
		//Added by Mesfin
		app.post("/login", lc.loginHandler);
<<<<<<< HEAD
=======
		
		
		//add some users
		User u1 = new User("test@gmail.com", "username", "password", "Billy", "Bob", "10/15/2021");
		UserDao uDao = new UserDao();
		
		uDao.insertUser(u1);
>>>>>>> parent of 0fc0ec34e (Registration functionality)

>>>>>>> parent of 171a02461 (fixed reviewsByUser, bug in reviewsByDrink)

	}

}

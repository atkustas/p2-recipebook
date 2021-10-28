package com.revature;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.controllers.LoginController;
import com.revature.controllers.RegistrationController;
import com.revature.controllers.ReviewController;
import com.revature.daos.CocktailDao;
import com.revature.daos.ReviewDao;
import com.revature.daos.UserDao;
import com.revature.models.Cocktail;
import com.revature.models.Review;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		
		System.out.println("%%%%% MAIN LOADED %%%%%");
		
		LoginController lc = new LoginController();
		CocktailDao cd = new CocktailDao();
		ReviewController rvc = new ReviewController();
		RegistrationController rc = new RegistrationController();
		ReviewDao rd = new ReviewDao();
		
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
		
		app.post("/login", lc.loginHandler);
		app.post("/register", rc.register);
		
		app.post("/addreview", rvc.addreview);
		app.get("/allreviews", rvc.getallreviews);
		app.post("/reviewsbyuser", rvc.reviewsbyuser);
		app.post("/drinkreviews", rvc.reviewsbydrink);
		
		app.post("/returnuser", lc.returnuser);

		
		
		//add some users
		User u1 = new User("test@gmail.com", "username", "password", "Billy", "Bob", "10/15/2021");
		UserDao uDao = new UserDao();
		
		uDao.insertUser(u1);
		
		//add some cocktails
		Cocktail c1 = new Cocktail("Whiskey Sour");
		Cocktail c2 = new Cocktail("Moscow Mule");
		
		cd.addCocktail(c1);
		cd.addCocktail(c2);
		
		Review r1 = new Review(u1, c1, "pretty good", "today");
		rd.addReview(r1);
		


	}

}

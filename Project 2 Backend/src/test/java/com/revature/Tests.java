package com.revature;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.revature.daos.CocktailDao;
import com.revature.daos.FavoriteDao;
import com.revature.daos.ReviewDao;
import com.revature.daos.UserDao;
import com.revature.models.Cocktail;
import com.revature.models.Favorite;
import com.revature.models.Review;
import com.revature.models.User;
import com.revature.services.CocktailService;
import com.revature.services.FavoriteService;
import com.revature.services.LoginService;
import com.revature.services.ReviewService;
import com.revature.services.UserService;

public class Tests {

	public static LoginService ls = new LoginService();
	public static UserDao uDao = new UserDao();
	public static FavoriteDao fDao = new FavoriteDao();
	public static ReviewDao rDao = new ReviewDao();
	public static UserService rgs = new UserService();
	public static FavoriteService fs = new FavoriteService();
	public static ReviewService rs = new ReviewService();
	public static User us = new User("test@gmail.com", "username", "password", "Billy", "Bob", "10/15/2021");
	public static CocktailService cs = new CocktailService();
	public static CocktailDao cDao = new CocktailDao();
	
	public String testUsername = "username";
	public String testPassword = "password";
	
	public String testUsername2 = "orange";
	public String testPassword2 = "wackypassword";
	public boolean result;
	

	@BeforeAll 
	public static void beforeAll() {
		System.out.println("In the @BeforeAll method");
	}
	
	@AfterAll 
	public static void afterAll() {
		System.out.println("In the @AfterAll method");
		us=null;
	}

//	@Test
//	public void testLogin(String username, String password) {
//		result = ls.login(testUsername, testPassword);
//		assertTrue(result == true);
//	}
//	
//	@Test
//	public void testLogin2(String username, String password) {
//		result = ls.login(testUsername2, testPassword2);
//		assertTrue(result == false);
//	}
	
	@Test
	public void testGetUserByUsernameInvalid() {
		System.out.println("Get Users By User Name Invalid Test");
		User u = uDao.findUserByUsername("");
		assertNull(u);
		System.out.println("Test Passed");
	}

	@Test
	public void testAddFavorite() {
		System.out.println("Testing Add Favorite functionality");
		System.out.println();
		List<Review> reviewList = rDao.getAllReviews();
		List<Review> reviewList2 = rs.allReviews();
		assertEquals(reviewList, reviewList2);
		System.out.println("Test Passed");
	}

	
	@Test
	public void testAddCocktail() {
		System.out.println("Testing Add Cocktail functionality");
		System.out.println();
		Cocktail c=new Cocktail("Test Drink");
		cDao.addCocktail(c);
		Cocktail c2=cDao.findDrinkByDrinkName("Test Drink");
		assertEquals("Test Drink", c2.getDrink());
		System.out.println("Test Passed");
}
//	@Test
//	public void testViewFavorite() {
//		System.out.println("Testing View Favorite functionality");
//		System.out.println();
//		User u1 = new User("test@gmail.com", "username", "password", "Billy", "Bob", "10/15/2021");
//		List<Favorite> f1=fDao.viewFavorites(u1);
//		List<Favorite> f2=fs.viewFavorites(u1);
//		
//		assertEquals(f1, f2);
//		System.out.println("Test Passed");
//}

	@Test
	public void testGetAllReviews() {
		System.out.println("Testing View All Reviews functionality");
		System.out.println();
		List<Review> r1=rDao.getAllReviews();
		List<Review> r2=rs.allReviews();
		assertEquals(r1, r2);
		System.out.println("Test Passed");
}
	
	@Test
	public void testReviewByUser() {
		System.out.println("Testing Review By User functionality");
		System.out.println();
		User u1 = new User("test@gmail.com", "username", "password", "Billy", "Bob", "10/15/2021");
		List<Review> r1=rDao.reviewsByUser(u1);
		List<Review> r2=rs.reviewsByUser(u1);
		assertEquals(r1, r2);
		System.out.println("Test Passed");
}
	@Test
	public void testReturnUser() {
		System.out.println("Testing Return User functionality");
		System.out.println();
		List<User> u1=uDao.getUserByCredentials("Username","password");
		List<User> u2=ls.getUserByCredentials("Username","password");
		assertEquals(u1, u2);
		System.out.println("Test Passed");
}

	}

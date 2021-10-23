package com.revature;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.revature.daos.FavoriteDao;
import com.revature.daos.ReviewDao;
import com.revature.daos.UserDao;
import com.revature.models.Review;
import com.revature.services.FavoriteService;
import com.revature.services.LoginService;
import com.revature.services.ReviewService;
import com.revature.services.UserService;

public class Test {

	public static LoginService ls; 
	UserDao uDao = new UserDao();
	FavoriteDao fDao = new FavoriteDao();
	ReviewDao rDao = new ReviewDao();
	UserService rgs = new UserService();
	FavoriteService fs = new FavoriteService();
	ReviewService rs = new ReviewService();
		
	
	@BeforeAll
	public static void createServiceObject() {
		ls = new LoginService();
		System.out.println("Before all");
	}
	
	@AfterAll
	public static void clearServiceObject() {
		ls = null;
		System.out.println("After all");
	}

//	@Test
	public static void testCorrectLogin() {
		System.out.println("Testing Successsful Employee Login");
		System.out.println();
		assertTrue(ls.login("username", "password"));
	}

//	@Test
	public static void testFaildLogin() {
		System.out.println("Testing Successsful Employee Login");
		System.out.println();
		assertFalse(ls.login("uname", "pass"));
	}
	
//	@Test
	public void testAddFavorite() {
		
		List<Review> reviewList = rDao.getAllReviews();
		List<Review> reviewList2 = rs.allReviews();
		
		assertEquals(reviewList, reviewList2);
		
	}
	


}

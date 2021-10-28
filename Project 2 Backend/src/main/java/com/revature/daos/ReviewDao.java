package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Review;
import com.revature.utils.HibernateUtil;

public class ReviewDao implements ReviewInterface {

	@Override
	public void addReview(Review r) {
		Session ses = HibernateUtil.getSession();
		
		ses.save(r);
		HibernateUtil.closeSession();
	}

	
}

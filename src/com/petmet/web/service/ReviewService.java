package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.ReviewDao;
import com.petmet.web.dao.jdbc.JdbcReviewDao;
import com.petmet.web.entity.Review;

public class ReviewService {
	
	private ReviewDao rDao;
	
	public ReviewService() {
		rDao = new JdbcReviewDao();
	}
	
	public int insert(Review review) {
		return rDao.insert(review);
	}
	
	public int update(Review review) {
		return rDao.update(review);
	}
	
	public int delete(int id) {
		return rDao.delete(id);
	}
	
	public Review get(int id) {
		return rDao.get(id);
	}
	
	public List<Review> getList() {
		return rDao.getList();
	}
}

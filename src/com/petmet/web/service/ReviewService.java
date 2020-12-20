package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.ReviewDao;
import com.petmet.web.dao.jdbc.JdbcReviewDao;
import com.petmet.web.entity.Review;
import com.petmet.web.entity.ReviewView;

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

	public List<ReviewView> getViewList(int id) {
		
		return rDao.getViewList(id);
	}

	public int getTotalPage(int id, int page, int size) {
		int records = 0;
		
		List<ReviewView> list = rDao.getViewList(id);
		for(ReviewView v : list)
			records++;
		
		int pages = (int) Math.ceil(records / (float) size);
		
		return pages;
	}

}

package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Review;

public interface ReviewDao {

	int insert(Review review);
	int update(Review review);
	int delete(int id);
	
	Review get(int id);
	List<Review> getList();
	
}

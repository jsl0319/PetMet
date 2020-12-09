package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Feed;

public interface FeedDao {
	int insert(Feed feed);
	int update(Feed feed);
	int delete(int id);
	
	Feed get(int id);
	List<Feed> getList();
	List<Feed> getList(int page);
	
}

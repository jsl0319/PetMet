package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.FeedDao;
import com.petmet.web.dao.jdbc.JdbcFeedDao;
import com.petmet.web.entity.Feed;

public class FeedService {

	private FeedDao feedDao;
	
	//service 생성자
	public FeedService() {
		feedDao = new JdbcFeedDao();
	}
	
	
	
	public List<Feed> getList() {
	      
		return feedDao.getList();
	}
	public List<Feed> getList(int page) {
	      
		return feedDao.getList(page);
	}

	public Feed get(int id) {
		
		return feedDao.get(id);
	}

	public int insert(Feed feed) {
		
		return feedDao.insert(feed);
	}

	public int update(Feed feed) {
		int result = 0;
		
		result = feedDao.update(feed);
		return result;
	}

	public int delete(int id) {
		int result = 0;
		
		result = feedDao.delete(id);
		return result;
		
	}
}
package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.FeedReportDao;
import com.petmet.web.dao.jdbc.JdbcFeedReportDao;
import com.petmet.web.entity.FeedReport;

public class FeedReportService {

	private FeedReportDao feedReportDao;
	
	public FeedReportService() {
		feedReportDao = new JdbcFeedReportDao();
	}
	
	public List<FeedReport> getList() {
	      
		return feedReportDao.getList();
	}
	
	public List<FeedReport> getList(int page) {
	      
		return feedReportDao.getList(page);
	}

	public FeedReport get(int id) {
		
		return feedReportDao.get(id);
	}

	public int insert(FeedReport feedReport) {
		
		return feedReportDao.insert(feedReport);
	}

	public int update(FeedReport feedReport) {
		int result = 0;
		
		result = feedReportDao.update(feedReport);
		return result;
	}

	public int delete(int id) {
		int result = 0;
		
		result = feedReportDao.delete(id);
		return result;
		
	}
	
}

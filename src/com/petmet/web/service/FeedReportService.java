package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.FeedReportDao;
import com.petmet.web.dao.jdbc.JdbcFeedReportDao;
import com.petmet.web.entity.FeedReport;
import com.petmet.web.entity.ReportedFeedView;

public class FeedReportService {

	private FeedReportDao feedReportDao;
	
	
	public FeedReportService() {
		feedReportDao = new JdbcFeedReportDao();
	}
	
	public List<FeedReport> getList(int page, int size, String query){
		
		int startIndex = 1+(page-1)*size;
	    int endIndex = page*10;
	      
		return feedReportDao.getList(startIndex,endIndex,query);
	}
	
	
	public List<FeedReport> getList(int page) {
	      
		return feedReportDao.getList(page);
	}
	
	
	public List<FeedReport> getList() {
	      
		return feedReportDao.getList();
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
	
	public List<ReportedFeedView> getViewList(){
		return getViewList();
	}
	
	public List<ReportedFeedView> getViewList(int page, int size){
		
		int startIndex = 1+(page-1)*size;
	    int endIndex = page*10;
	      
		return getViewList(startIndex, endIndex);
	}
	
	
	public int getLastId() {
		FeedReport fr = feedReportDao.getLast();
		
		return fr.getId();
	}
	
}

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
	

	
	public FeedReport get(int id) {
		return feedReportDao.get(id);
	}
	public int insert(FeedReport feedReport) {
		return feedReportDao.insert(feedReport);
	}
	public int update(FeedReport feedReport) {
		return feedReportDao.update(feedReport);
	}
	public int delete(int id) {
		return feedReportDao.delete(id);
	}
	

	
	public FeedReport getPrev(int id) {
		return feedReportDao.getPrev(id);
	}
	public FeedReport getNext(int id) {
		return feedReportDao.getNext(id);
	}
	
	
	
	public int getListCount(String field, String query) {
		return feedReportDao.getListCount(field, query);
	}
	
	public int getViewListCount(String field, String query) {
		return feedReportDao.getViewListCount(field, query);
	}
//	

	
	
	
	public List<FeedReport> getList(String field, String query, String startDate, String endDate, int page, int size){
		
		int startIndex = 1+(page-1)*size;
	    int endIndex = page*size;
	      
		return feedReportDao.getList(field, query, startDate, endDate, startIndex, endIndex);
	}
	
	
	
	
	public List<ReportedFeedView> getViewList(String field, String query, int page, int size){
		
		int startIndex = 1+(page-1)*size;
	    int endIndex = page * size;
	      
		return feedReportDao.getViewList(field, query, startIndex, endIndex);
	}
	
	
	
	
	public int getLastId() {
		FeedReport fr = feedReportDao.getLast();
		
		return fr.getId();
	}



	
	
}

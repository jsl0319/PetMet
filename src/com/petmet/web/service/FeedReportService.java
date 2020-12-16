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
	
	
	
	public List<FeedReport> getList(int page, int size){
		
		int startIndex = 1+(page-1)*size;
	    int endIndex = page*15;
	      
		return feedReportDao.getList(startIndex,endIndex);
	}
	public List<FeedReport> getList(int page) {
		return feedReportDao.getList(page,15);
	}
	public List<FeedReport> getList() {
		return feedReportDao.getList(1,15);
	}
	
	
	public List<ReportedFeedView> getViewList(int page, int size){
		
		int startIndex = 1+(page-1)*size;
	    int endIndex = page*10;
	      
		return feedReportDao.getViewList(startIndex, endIndex);
	}
	public List<ReportedFeedView> getViewList(int page){
		return feedReportDao.getViewList(page,10);
	}
	public List<ReportedFeedView> getViewList(){
		return feedReportDao.getViewList(1,10);
	}
	
	
	
	
	public int getLastId() {
		FeedReport fr = feedReportDao.getLast();
		
		return fr.getId();
	}
	
}

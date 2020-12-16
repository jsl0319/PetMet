package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.FeedReport;
import com.petmet.web.entity.ReportedFeedView;

public interface FeedReportDao {
	int insert(FeedReport feedReport);
	int update(FeedReport feedReport);
	int delete(int id);
	
	FeedReport get(int id);
//	List<FeedReport> getList();
//	List<FeedReport> getList(int startIndex);
	List<FeedReport> getList(int startIndex, int endIndex);
	
//	List<ReportedFeedView> getViewList();
//	List<ReportedFeedView> getViewList(int startIndex, int endIndex);
	List<ReportedFeedView> getViewList(int startIndex, int endIndex);
	FeedReport getLast();
	
}

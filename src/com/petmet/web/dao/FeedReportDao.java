package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.FeedReport;

public interface FeedReportDao {
	int insert(FeedReport feedReport);
	int update(FeedReport feedReport);
	int delete(int id);
	
	FeedReport get(int id);
	List<FeedReport> getList();
	List<FeedReport> getList(int page);
	
}

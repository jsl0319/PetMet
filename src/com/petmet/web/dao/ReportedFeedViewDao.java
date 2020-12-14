package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.ReportedFeedView;

public interface ReportedFeedViewDao {
	int insert(ReportedFeedView reportedfeedView);
	int update(ReportedFeedView reportedfeedView);
	int delete(int id);
	
	ReportedFeedView get(int id);
	List<ReportedFeedView> getList();
	List<ReportedFeedView> getList(int page);
}

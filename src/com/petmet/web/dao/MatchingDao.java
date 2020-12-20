package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Matching;
import com.petmet.web.entity.MatchingView;

public interface MatchingDao {
//	int insert(Matching matching);
//
//	int update(Matching matching);
//
//	int delete(int id);
//
//	Matching get(int id);
//
//	List<Matching> getList();

	List<Matching> getReportList(String field, String query, int startIndex, int endIndex);

	Matching getReport(int id);

	List<MatchingView> getList(int field, String startDate, String endDate, int startIndex, int endIndex);
	MatchingView get(int id);

	int getCount(int field, String startDate, String endDate);

	int getReportCount(String field, String query);


}

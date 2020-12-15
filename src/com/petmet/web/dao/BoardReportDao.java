package com.petmet.web.dao;

import java.util.Date;
import java.util.List;

import com.petmet.web.entity.BoardReport;
import com.petmet.web.entity.BoardReportView;

public interface BoardReportDao {
	int insert(BoardReport boardReport);
	int update(BoardReport boardReport);
	int delete(int id);
	BoardReport get(int id);
	
	List<BoardReport> getList(String selectBox, String query, String boardCategory, Date startDate, Date endDate, int startIndex, int endIndex);
	List<BoardReportView> getViewList(String selectBox, String query, String boardCategory, Date startDate, Date endDate, int startIndex, int endIndex);
}

package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.BoardReport;

public interface BoardReportDao {
	int insert(BoardReport boardReport);

	int update(BoardReport boardReport);

	int delete(int id);

	BoardReport get(int id);

	List<BoardReport> getList();
	
	int deleteList(List<Integer> ids);
	
	BoardReport getPrev(int id);

	BoardReport getNext(int id);
}

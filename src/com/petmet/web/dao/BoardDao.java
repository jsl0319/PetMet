package com.petmet.web.dao;

import java.util.Date;
import java.util.List;

import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardView;

public interface BoardDao {
	int insert(Board board);
	int update(Board board);
	int delete(int id);
	Board get(int id);

	List<Board> getList(String selectBox, String query, String boardCategory, Date startDate, Date endDate, int startIndex, int endIndex);
	List<BoardView> getViewList(String selectBox, String query, String boardCategory, Date startDate, Date endDate, int startIndex, int endIndex);
	BoardView getView(int id);
	
}

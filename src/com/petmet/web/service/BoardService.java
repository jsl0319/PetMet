package com.petmet.web.service;

import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardCategoryDao;
import com.petmet.web.dao.BoardDao;
import com.petmet.web.dao.jdbc.JdbcBoardCategoryDao;
import com.petmet.web.dao.jdbc.JdbcBoardDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardView;

public class BoardService {
	private BoardDao boardDao;
	
	//---------------------------------- Constructor ----------------------------------
	public BoardService() {
		boardDao = new JdbcBoardDao();
	}
	
	//---------------------------------- Functions ----------------------------------
	public int insert(Board board) {
		return boardDao.insert(board);
	}
	
	public int update(Board board) {
		return boardDao.update(board);
	}
	
	public int delete(int id) {
		return boardDao.delete(id);
	}
	
	public Board get(int id) {
		return boardDao.get(id);
	}
	
	// -------------- getList --------------
	public List<Board> getList() {
		return getList(null, null, null, null, null, 1, 20);
	}
	
	// ---- getList 최종
	public List<Board> getList(String selectBox, String query, String boardCategory
								, String startDate, String endDate, int page, int size){
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;
		
		return boardDao.getList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------
	public int deleteList(int[] ids) {
		int result = 0;
		
		for(int i=0; i < ids.length; i++, result++) {
			int id = ids[i];
			boardDao.delete(id);
		}
		
		return result;
	}
	
	public int updateList(List<Board> list) {
		int result = 0;
		
		for(Board board : list) {
			boardDao.update(board);
			result++;
		}
		
		return result;
	}
	
	public BoardView getPrev(int id) {
		String subQuery = "WHERE NUM = (SELECT NUM FROM BOARD_VIEW WHERE ID = " + id + ") + 1";
		return boardDao.getView(subQuery);
	}
	
	public BoardView getNext(int id) {
		String subQuery = "WHERE NUM = (SELECT NUM FROM BOARD_VIEW WHERE ID = " + id + ") - 1";
		return boardDao.getView(subQuery);
	}
	
	public List<BoardCategory> getCategoryList(){
		BoardCategoryDao categoryDao = new JdbcBoardCategoryDao();
		return categoryDao.getList();
	}
	
	public int getTotalPage(String field, String query, String board, String startDate, String endDate, int page, int size) {
		int records = 0;

		List<BoardView> list = boardDao.getViewList(field, query, board, startDate, endDate);
		for (BoardView b : list)
			records++;

		int pages = (int) Math.ceil(records / (float) size);

		return pages;
	}
	
	// -------------- getViewList --------------
	public List<BoardView> getViewList() {
		return getViewList(null, null, null, null, null, 1, 20);
	}
	
	// ---- getViewList 최종
	public List<BoardView> getViewList(String selectBox, String query, String boardCategory
								, String startDate, String endDate, int page, int size){
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;
		
		return boardDao.getViewList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------
}
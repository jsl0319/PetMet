package com.petmet.web.service;

import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardCategoryDao;
import com.petmet.web.dao.BoardDao;
import com.petmet.web.dao.BoardReportDao;
import com.petmet.web.dao.jdbc.JdbcBoardCategoryDao;
import com.petmet.web.dao.jdbc.JdbcBoardDao;
import com.petmet.web.dao.jdbc.JdbcBoardReportDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardReport;
import com.petmet.web.entity.BoardReportView;
import com.petmet.web.entity.BoardView;

public class BoardReportService {
	private BoardReportDao boardReportDao;

	// ---------------------------------- Constructor ----------------------------------
	public BoardReportService() {
		boardReportDao = new JdbcBoardReportDao();
	}

	// ---------------------------------- Functions ----------------------------------
	public int insert(BoardReport boardReport) {
		return boardReportDao.insert(boardReport);
	}

	public int update(BoardReport boardReport) {
		return boardReportDao.update(boardReport);
	}

	public int delete(int id) {
		return boardReportDao.delete(id);
	}

	public BoardReport get(int id) {
		return boardReportDao.get(id);
	}
	
	public List<BoardReport> getListByBoardId(int boardId){
		return boardReportDao.getListByBoardId(boardId);
	}

	// -------------- getList --------------
	public List<BoardReport> getList() {
		return getList(null, null, null, null, null, 1, 20);
	}
	
	// ---- getList 최종
	public List<BoardReport> getList(String selectBox, String query, String boardCategory, String startDate, String endDate,
			int page, int size) {
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return boardReportDao.getList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}

	// ---------------------------------------
	public int deleteList(int[] ids) {
		int result = 0;

		for (int i = 0; i < ids.length; i++, result++) {
			int id = ids[i];
			boardReportDao.delete(id);
		}

		return result;
	}

	public int deleteBoardList(int[] ids) {
		int result = 0;
		BoardDao boardDao = new JdbcBoardDao();
		
		for(int i=0; i < ids.length; i++, result++) {
			int id = ids[i];
			boardDao.delete(id);
		}
		
		return result;
	}
	public BoardReportView getPrev(int id) {
		String subQuery = "WHERE NUM = (SELECT NUM FROM BOARD_REPORT_VIEW WHERE BOARD_ID = " + id + ") + 1";
		
		return boardReportDao.getView(subQuery);
	}

	public BoardReportView getNext(int id) {
		String subQuery = "WHERE NUM = (SELECT NUM FROM BOARD_REPORT_VIEW WHERE BOARD_ID = " + id + ") - 1";
		
		return boardReportDao.getView(subQuery);
	}
	
	public List<BoardCategory> getCategoryList(){
		BoardCategoryDao categoryDao = new JdbcBoardCategoryDao();
		return categoryDao.getList();
	}
	
	public Board getBoard(int id) {
		BoardDao boardDao = new JdbcBoardDao();
		return boardDao.get(id);
	}
	
	public BoardView getBoardView(int id) {
		BoardDao boardDao = new JdbcBoardDao();
		return boardDao.getView(id);
	}

	public int getTotalPage(String field, String query, String board, String startDate, String endDate, int page, int size) {
		int records = 0;

		List<BoardReportView> list = boardReportDao.getViewList(field, query, board, startDate, endDate);
		for (BoardReportView b : list)
			records++;

		int pages = (int) Math.ceil(records / (float) size);

		return pages;
	}
	
	// -------------- getViewList --------------
	public List<BoardReportView> getViewList() {
		return getViewList(null, null, null, null, null, 1, 20);
	}
	// ---- getViewList 최종
	public List<BoardReportView> getViewList(String selectBox, String query, String boardCategory, String startDate,
			String endDate, int page, int size) {
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return boardReportDao.getViewList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------

}

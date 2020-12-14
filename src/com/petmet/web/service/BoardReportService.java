package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.BoardReportDao;
import com.petmet.web.dao.jdbc.JdbcBoardReportDao;
import com.petmet.web.entity.BoardReport;

public class BoardReportService {
	private BoardReportDao boardReportDao;
	
	//---------------------------------- Constructor ----------------------------------
	public BoardReportService() {
		boardReportDao = new JdbcBoardReportDao();
	}
	
	//---------------------------------- Functions ----------------------------------
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

	public List<BoardReport> getList() {
		return boardReportDao.getList();
	}

}

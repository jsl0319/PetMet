package com.petmet.web.service;

import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardReportDao;
import com.petmet.web.dao.jdbc.JdbcBoardReportDao;
import com.petmet.web.entity.BoardReport;
import com.petmet.web.entity.BoardReportView;

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

	// -------------- getList --------------
	public List<BoardReport> getList() {
		return getList(null, null, null, null, null, 1, 20);
	}

	public List<BoardReport> getList(int page) {
		return getList(null, null, null, null, null, page, 20);
	}

	public List<BoardReport> getList(int page, int size) {
		return getList(null, null, null, null, null, page, size);
	}

	public List<BoardReport> getList(String selectBox, String query) {
		return getList(selectBox, query, null, null, null, 1, 20);
	}

	public List<BoardReport> getList(String boardCategory) {
		return getList(null, null, boardCategory, null, null, 1, 20);
	}

	public List<BoardReport> getList(Date startDate, Date endDate) {
		return getList(null, null, null, startDate, endDate, 1, 20);
	}

	public List<BoardReport> getList(String selectBox, String query, int page) {
		return getList(selectBox, query, null, null, null, page, 20);
	}

	public List<BoardReport> getList(String selectBox, String query, int page, int size) {
		return getList(selectBox, query, null, null, null, page, size);
	}

	public List<BoardReport> getList(String boardCategory, int page) {
		return getList(null, null, boardCategory, null, null, page, 20);
	}

	public List<BoardReport> getList(String boardCategory, int page, int size) {
		return getList(null, null, boardCategory, null, null, page, size);
	}

	public List<BoardReport> getList(Date startDate, Date endDate, int page) {
		return getList(null, null, null, startDate, endDate, page, 20);
	}

	public List<BoardReport> getList(Date startDate, Date endDate, int page, int size) {
		return getList(null, null, null, startDate, endDate, page, size);
	}

	public List<BoardReport> getList(String selectBox, String query, String boardCategory, int page) {
		return getList(selectBox, query, boardCategory, null, null, page, 20);
	}

	public List<BoardReport> getList(String selectBox, String query, String boardCategory, int page, int size) {
		return getList(selectBox, query, boardCategory, null, null, page, size);
	}

	public List<BoardReport> getList(String boardCategory, Date startDate, Date endDate, int page) {
		return getList(null, null, boardCategory, startDate, endDate, page, 20);
	}

	public List<BoardReport> getList(String boardCategory, Date startDate, Date endDate, int page, int size) {
		return getList(null, null, boardCategory, startDate, endDate, page, size);
	}

	public List<BoardReport> getList(String selectBox, String query, Date startDate, Date endDate, int page) {
		return getList(selectBox, query, null, startDate, endDate, page, 20);
	}

	public List<BoardReport> getList(String selectBox, String query, Date startDate, Date endDate, int page, int size) {
		return getList(selectBox, query, null, startDate, endDate, page, size);
	}

	// ---- getList 최종
	public List<BoardReport> getList(String selectBox, String query, String boardCategory, Date startDate, Date endDate,
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

	BoardReport getPrev(int id) {
		return boardReportDao.get(id - 1);
	}

	BoardReport getNext(int id) {
		return boardReportDao.get(id + 1);
	}

	// -------------- getViewList --------------
	public List<BoardReportView> getViewList() {
		return getViewList(null, null, null, null, null, 1, 20);
	}

	public List<BoardReportView> getViewList(int page) {
		return getViewList(null, null, null, null, null, page, 20);
	}

	public List<BoardReportView> getViewList(int page, int size) {
		return getViewList(null, null, null, null, null, page, size);
	}

	public List<BoardReportView> getViewList(String selectBox, String query) {
		return getViewList(selectBox, query, null, null, null, 1, 20);
	}

	public List<BoardReportView> getViewList(String boardCategory) {
		return getViewList(null, null, boardCategory, null, null, 1, 20);
	}

	public List<BoardReportView> getViewList(Date startDate, Date endDate) {
		return getViewList(null, null, null, startDate, endDate, 1, 20);
	}

	public List<BoardReportView> getViewList(String selectBox, String query, int page) {
		return getViewList(selectBox, query, null, null, null, page, 20);
	}

	public List<BoardReportView> getViewList(String selectBox, String query, int page, int size) {
		return getViewList(selectBox, query, null, null, null, page, size);
	}

	public List<BoardReportView> getViewList(String boardCategory, int page) {
		return getViewList(null, null, boardCategory, null, null, page, 20);
	}

	public List<BoardReportView> getViewList(String boardCategory, int page, int size) {
		return getViewList(null, null, boardCategory, null, null, page, size);
	}

	public List<BoardReportView> getViewList(Date startDate, Date endDate, int page) {
		return getViewList(null, null, null, startDate, endDate, page, 20);
	}

	public List<BoardReportView> getViewList(Date startDate, Date endDate, int page, int size) {
		return getViewList(null, null, null, startDate, endDate, page, size);
	}

	public List<BoardReportView> getViewList(String selectBox, String query, String boardCategory, int page) {
		return getViewList(selectBox, query, boardCategory, null, null, page, 20);
	}

	public List<BoardReportView> getViewList(String selectBox, String query, String boardCategory, int page, int size) {
		return getViewList(selectBox, query, boardCategory, null, null, page, size);
	}

	public List<BoardReportView> getViewList(String boardCategory, Date startDate, Date endDate, int page) {
		return getViewList(null, null, boardCategory, startDate, endDate, page, 20);
	}

	public List<BoardReportView> getViewList(String boardCategory, Date startDate, Date endDate, int page, int size) {
		return getViewList(null, null, boardCategory, startDate, endDate, page, size);
	}

	public List<BoardReportView> getViewList(String selectBox, String query, Date startDate, Date endDate, int page) {
		return getViewList(selectBox, query, null, startDate, endDate, page, 20);
	}

	public List<BoardReportView> getViewList(String selectBox, String query, Date startDate, Date endDate, int page,
			int size) {
		return getViewList(selectBox, query, null, startDate, endDate, page, size);
	}

	// ---- getViewList 최종
	public List<BoardReportView> getViewList(String selectBox, String query, String boardCategory, Date startDate,
			Date endDate, int page, int size) {
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return boardReportDao.getViewList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------
}

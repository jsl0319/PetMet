package com.petmet.web.service;

import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardDao;
import com.petmet.web.dao.jdbc.JdbcBoardDao;
import com.petmet.web.entity.Board;

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

	public List<Board> getList() {
		return boardDao.getList();
	}

	public List<Board> getList(int category, String searchContent, int page) {
		return boardDao.getList(category, searchContent, page);
	}

	public List<Board> getList(int boardCategory, int page) {
		return boardDao.getList(boardCategory, page);
	}

	public List<Board> getList(Date startDate, Date endDate, int page) {
		return boardDao.getList(startDate, endDate, page);
	}

	public List<Board> getList(int category, String searchContent, int boardCategory, int page) {
		return boardDao.getList(category, searchContent, boardCategory, page);
	}

	public List<Board> getList(int category, String searchContent, Date startDate, Date endDate, int page) {
		return boardDao.getList(category, searchContent, startDate, endDate, page);
	}

	public List<Board> getList(int boardCategory, Date startDate, Date endDate, int page) {
		return boardDao.getList(boardCategory, startDate, endDate, page);
	}

	public List<Board> getList(int category, String searchContent, int boardCategory, Date startDate, Date endDate,
			int page) {
		return boardDao.getList(category, searchContent, boardCategory, startDate, endDate, page);
	}

	public int deleteList(List<Integer> ids) {
		return boardDao.deleteList(ids);
	}

	public Board getPrev(int id) {
		return boardDao.getPrev(id);
	}

	public Board getNext(int id) {
		return boardDao.getNext(id);
	}

}
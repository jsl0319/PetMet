package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.BoardCategoryDao;
import com.petmet.web.dao.jdbc.JdbcBoardCategoryDao;
import com.petmet.web.entity.BoardCategory;

public class BoardCategoryService {
	private BoardCategoryDao boardCategoryDao;
	
	//---------------------------------- Constructor ----------------------------------
	public BoardCategoryService() {
		boardCategoryDao = new JdbcBoardCategoryDao();
	}
	
	//---------------------------------- Functions ----------------------------------
	public int insert(BoardCategory boardCategory) {
		return boardCategoryDao.insert(boardCategory);
	}
	
	public int update(BoardCategory boardCategory) {
		return boardCategoryDao.update(boardCategory);
	}
	public int delete(int id) {
		return boardCategoryDao.delete(id);
	}
	
	public BoardCategory get(int id) {
		return boardCategoryDao.get(id);
	}
	
	List<BoardCategory> getList(){
		return boardCategoryDao.getList();
	}
}

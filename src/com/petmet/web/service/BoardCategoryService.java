package com.petmet.web.service;

import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardCategoryDao;
import com.petmet.web.dao.jdbc.JdbcBoardCategoryDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardCategoryView;

public class BoardCategoryService {
	private BoardCategoryDao boardCategoryDao;

	// ---------------------------------- Constructor ----------------------------------
	public BoardCategoryService() {
		boardCategoryDao = new JdbcBoardCategoryDao();
	}

	// ---------------------------------- Functions ----------------------------------
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

	// -------------- getList --------------
	public List<BoardCategory> getList() {
		return getList(1);
	}
	
	public List<BoardCategory> getList(int page) {
		int startIndex = 1 + (page - 1) * 20;
		int endIndex = 20 * page;
		
		return boardCategoryDao.getList(startIndex, endIndex);
	}
	
	// ---------------------------------------
	public int deleteList(int[] ids) {
		int result = 0;

		for (int i = 0; i < ids.length; i++, result++) {
			int id = ids[i];
			boardCategoryDao.delete(id);
		}

		return result;
	}

	public int updateList(List<BoardCategory> list) {
		int result = 0;

		for (BoardCategory boardCateogry : list) {
			boardCategoryDao.update(boardCateogry);
			result++;
		}

		return result;
	}
	
	public int insertList(List<BoardCategory> list) {
		int result = 0;

		for (BoardCategory boardCateogry : list) {
			boardCategoryDao.insert(boardCateogry);
			result++;
		}

		return result;
	}

	BoardCategory getPrev(int id) {
		return boardCategoryDao.get(id - 1);
	}

	BoardCategory getNext(int id) {
		return boardCategoryDao.get(id + 1);
	}

	// -------------- getViewList --------------
	public List<BoardCategoryView> getViewList() {
		return getViewList(1);
	}
	
	public List<BoardCategoryView> getViewList(int page) {
		int startIndex = 1 + (page - 1) * 20;
		int endIndex = 20 * page;
		
		return boardCategoryDao.getViewList(startIndex, endIndex);
	}
}

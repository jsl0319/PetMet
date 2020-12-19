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
	// -------------- 기본 CRUD 기능 --------------
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

	// -------------- 추가 기능 --------------
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

	public BoardCategory getPrev(int id) {
		return boardCategoryDao.get(id - 1);
	}

	public BoardCategory getNext(int id) {
		return boardCategoryDao.get(id + 1);
	}
	
	public int getPageTotal(int size){
		int records = 0;
		
		List<BoardCategory> cList = boardCategoryDao.getList();
		for(BoardCategory c : cList)
			records++;
		
		int pages = (int)Math.ceil(records / (float)size);
		
		return pages;
	}
	
	// -------------- getList --------------
	public List<BoardCategory> getList() {
		return getList(1);
	}

	public List<BoardCategory> getList(int page) {
		return getList(page, 10);
	}
	
	public List<BoardCategory> getList(int page, int size) {
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return boardCategoryDao.getList(startIndex, endIndex);
	}

	// -------------- getViewList --------------
	public List<BoardCategoryView> getViewList() {
		return getViewList(1);
	}

	public List<BoardCategoryView> getViewList(int page) {
		return getViewList(1, 10);
	}
	
	public List<BoardCategoryView> getViewList(int page, int size) {
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return boardCategoryDao.getViewList(startIndex, endIndex);
	}
}

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
	
	// -------------- getList --------------
	public List<Board> getList() {
		return boardDao.getList();
	}
	
	public List<Board> getList(int page){
		return getList(1, 20);
	}
	
	public List<Board> getList(int page, int size){
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;
		
		return boardDao.getList(startIndex, endIndex);
	}
	
	public List<Board> getList(String searchOption, String searchText){
		return null;
	}
	
	public List<Board> getList()
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
	
}
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
	public List<Board> getList() {
		
		return boardDao.getList();
	}
	
	public int deleteList(int[] ids) {
		for(int i=0; i < ids.length; i++)
			
		return 0;
	}
}
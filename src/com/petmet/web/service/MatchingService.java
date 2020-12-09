package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.MatchingDao;
import com.petmet.web.dao.jdbc.JdbcMatchingDao;
import com.petmet.web.entity.Matching;

public class MatchingService{
	private MatchingDao matchingDao;
	
	//---------------------------------- Constructor ----------------------------------
	public MatchingService() {
		matchingDao = new JdbcMatchingDao();
	}
	
	//---------------------------------- Functions ----------------------------------
	public int insert(Matching matching) {
		
		return matchingDao.insert(matching);
	}

	public int update(Matching matching) {
		
		return matchingDao.update(matching);
	}

	public int delete(int id) {
		
		return matchingDao.delete(id);
	}

	public Matching get(int id) {
		
		return matchingDao.get(id);
	}

	public List<Matching> getList() {
		
		return matchingDao.getList();
	}
}

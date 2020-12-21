package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.AnswerDao;
import com.petmet.web.dao.jdbc.JdbcAnswerDao;
import com.petmet.web.entity.Answer;


public class AnswerService {
	
private AnswerDao answerDao;
	
	public AnswerService() {
		answerDao = new JdbcAnswerDao();
	}
	

	public List<Answer> getList() {
		return answerDao.getList();
	}

	// --------------------------------------------
	public Answer get(int id) { 
		return answerDao.get(id);
	
	}

	// -----------------------------------------
	public int insert(Answer answer) {
		return answerDao.insert(answer);
	}

	// ----------------------------
	public int update(Answer answer) {
		return answerDao.update(answer);

	}

	/// -----------------------------------
	public int delete(int id) {
		return answerDao.delete(id);
	}

	



}

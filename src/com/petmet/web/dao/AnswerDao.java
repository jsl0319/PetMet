package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Answer;

public interface AnswerDao {
	int insert(Answer answer);
	int delete(int id);
	int update(Answer answer);

	Answer get(int id);
	List<Answer> getList();
	
}

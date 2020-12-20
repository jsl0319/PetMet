package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Notice;
import com.petmet.web.entity.Question;

public interface QuestionDao {
	
	int insert(Question question);
	int update(Question question);
	int delet(int id);
	
	Question get(int id);
	List<Question> getList();
	int updateAnswer(Question q);

}

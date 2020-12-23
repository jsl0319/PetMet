package com.petmet.web.dao;

import java.util.Date;
import java.util.List;

import com.petmet.web.entity.Answer;
import com.petmet.web.entity.Notice;
import com.petmet.web.entity.Question;

public interface QuestionDao {
	
	int insert(Question question);
	int update(Question question);
	int delet(int id);
	
	Question get(int id);

	

	int getCount(String query,String startDate, String endDate);
	
	int updateAnswer(Question q);
	List<Question> getList(String query, int radio, String startDate, String endDate, int page, int size);



}

package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.DogDao;
import com.petmet.web.dao.jdbc.JdbcDogDao;
import com.petmet.web.entity.Dog;
import com.petmet.web.entity.Member;

public class DogService {
	
	private DogDao dogDao;
	
	public DogService() {
		dogDao = new JdbcDogDao();
	}
	

	public Dog get(int id) {
		Dog dog = dogDao.get(id);
		return dog;
	}


	public List<Dog> getList(String field, String query, String query2, int page, int num) {
		int startIndex = 1+(page-1)*num;     
		int endIndex = page*num;	 
		return dogDao.getList(field,query,query2,startIndex,endIndex);
	}
	

}

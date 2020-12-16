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
	
	public int insert(Member dog) {
		int result=0;
		
		return result;
		
	}
	
	public Dog get(int id) {
		Dog dog = dogDao.get(id);
		return dog;
	}
	
	public List<Dog> getList() {
		List<Dog> list = dogDao.getList();
		return list;
	}

}

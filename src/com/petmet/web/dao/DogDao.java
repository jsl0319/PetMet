package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Dog;

public interface DogDao {
	int insert(Dog dog);
	Dog get(int id);
	int update(Dog dog);
	int delete(int id);
	List<Dog> getList();
}

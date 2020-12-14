package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.PetPlaceCategory;

public interface PetPlaceCategoryDao {

	int insert(PetPlaceCategory ppc);
	int update(PetPlaceCategory ppc);
	int delete(int id);
	
	PetPlaceCategory get(int id);
	List<PetPlaceCategory> getList();
	
}

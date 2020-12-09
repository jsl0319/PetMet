package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.PetPlace;

public interface PetPlaceDao {
	
	int insert(PetPlace petPlace);
	int update(PetPlace petPlace);
	int delete(int id);
	
	PetPlace get(int id);
	List<PetPlace> getList();
	
//	List<PetPlace> getList(int category, String query, int page);
//	deleteList(int[] ids); 
//	pubList(int[] ids);
//	getPrevPage(int id);
//	getNextPage(int id);

	
}

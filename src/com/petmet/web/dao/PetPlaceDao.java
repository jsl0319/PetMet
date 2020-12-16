package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.PetPlace;
import com.petmet.web.entity.PetPlaceCategory;
import com.petmet.web.entity.PetPlaceView;

public interface PetPlaceDao {
	
	int insert(PetPlace petPlace);
	int update(PetPlace petPlace);
	int delete(int id);
	
	PetPlace get(int id);
	PetPlace getLast();
	List<PetPlace> getList();
	List<PetPlaceView> getViewList();
	
//	List<PetPlace> getList(int category, String query, int page);
//	deleteList(int[] ids); 
//	pubList(int[] ids);
//	getPrevPage(int id);
//	getNextPage(int id);

	
}

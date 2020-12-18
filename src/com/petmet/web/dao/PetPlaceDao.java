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

	PetPlaceView getLast();

	List<PetPlace> getList();

	List<PetPlaceView> getViewList();

	PetPlaceView getView(int id);

	List<PetPlaceView> getView(String field, String query, String startDate, String endDate, int startIndex,
			int endIndex);

	int getLastIndex();
	
}

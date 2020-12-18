package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.PetPlaceDao;
import com.petmet.web.dao.jdbc.JdbcPetPlaceDao;
import com.petmet.web.entity.PetPlace;
import com.petmet.web.entity.PetPlaceCategory;
import com.petmet.web.entity.PetPlaceView;

public class PetPlaceService {

	private PetPlaceDao ppDao;

	public PetPlaceService() {
		ppDao = new JdbcPetPlaceDao();
	}

	public int insert(PetPlace pp) {
		return ppDao.insert(pp);
	}

	public int update(PetPlace pp) {
		return ppDao.update(pp);
	}

	public int delete(int id) {
		return ppDao.delete(id);
	}

	public PetPlace get(int id) {
		return ppDao.get(id);
	}

	public int getLastId() {
		PetPlace pp = ppDao.getLast();
		return pp.getId();
	}

	// view ===================================

	public List<PetPlaceView> getList() {

		return ppDao.getViewList();
	}

//	public Pet

	public PetPlaceView getView(int id) {

		return ppDao.getView(id);
	}

	public List<PetPlaceView> getList(String field, String query, String startDate, String endDate, int page, int num) {

		int lastIndex = ppDao.getLastIndex();

//		int startIndex = lastIndex + (page - 1) * num * (-1);
//		int endIndex = lastIndex + page * num * (-1) + 1;
		int startIndex = lastIndex + page * num * (-1) + 1;
		int endIndex = lastIndex + (page - 1) * num * (-1);
		return ppDao.getView(field, query, startDate, endDate, startIndex, endIndex);
	}
}

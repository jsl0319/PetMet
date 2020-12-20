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

	public PetPlaceView getView(int id) {

		return ppDao.getView(id);
	}

	public List<PetPlaceView> getViewList(String field, String query, String startDate, String endDate, int page,
			int size) {

		int startIndex = 1 + (page - 1) * size;
		int endIndex = page * size;

		return ppDao.getViewList(field, query, startDate, endDate, startIndex, endIndex);
	}

	// review관리 페이지를 위한 getViewList
	public List<PetPlaceView> getViewList(String field, String query, int page, int size) {

		int startIndex = 1 + (page - 1) * size;
		int endIndex = page * size;

		return ppDao.getViewList(field, query, startIndex, endIndex);
	}

	public int getTotalPage(String field, String query, String startDate, String endDate, int page, int size) {

		int records = 0;

		List<PetPlaceView> list = ppDao.getViewList(field, query, startDate, endDate);
		for (PetPlaceView v : list)
			records++;

		int pages = (int) Math.ceil(records / (float) size);

		return pages;

	}

	public int getTotalPage(String field, String query, int page, int size) {
		
		int records = 0;

		List<PetPlaceView> list = ppDao.getViewList(field, query);
		for (PetPlaceView v : list)
			records++;

		int pages = (int) Math.ceil(records / (float) size);
		
		return pages;
		
	}

}

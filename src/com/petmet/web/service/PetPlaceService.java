package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.PetPlaceDao;
import com.petmet.web.dao.jdbc.JdbcPetPlaceDao;
import com.petmet.web.entity.PetPlace;

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
	
	public List<PetPlace> getList() {
		return ppDao.getList();
	}
}

package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.PetPlaceCategoryDao;
import com.petmet.web.dao.jdbc.JdbcPetPlaceCategoryDao;
import com.petmet.web.entity.PetPlaceCategory;
import com.petmet.web.entity.PetPlaceCategoryView;

public class PetPlaceCategoryService {
	
	private PetPlaceCategoryDao ppcDao;
	
	public PetPlaceCategoryService() {
		ppcDao = new JdbcPetPlaceCategoryDao();
	}
	
	public int insert(PetPlaceCategory ppc) {
		return ppcDao.insert(ppc);
	}
	
	public int update(PetPlaceCategory ppc) {
		return ppcDao.update(ppc);
	}
	
	public int delete(int id) {
		return ppcDao.delete(id);
	}
	
	public PetPlaceCategory get(int id) {
		return ppcDao.get(id);
	}
	
	public List<PetPlaceCategory> getList() {
		return ppcDao.getList();
	}

	public List<PetPlaceCategoryView> getViewList() {
		
		return ppcDao.getViewList();
	}

	public List<PetPlaceCategoryView> getViewList(String query, int page, int size) {
		
		int lastIndex = ppcDao.getLastIndex();
		
		int startIndex = lastIndex + page * size * (-1) + 1;
		int endIndex = lastIndex + (page - 1) * size * (-1);
		
		return ppcDao.getViewList(query, startIndex, endIndex);
	}
	
}

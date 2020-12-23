package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.MatchInfoDao;
import com.petmet.web.dao.jdbc.JdbcMatchInfoDao;
import com.petmet.web.entity.MatchInfoView;

public class MatchInfoService {



	private MatchInfoDao matchInfoDao;
	public MatchInfoService() {
		matchInfoDao = new JdbcMatchInfoDao();
	}
	
	public List<MatchInfoView> getViewList(){
		
		int startIndex =1;
		int endIndex = 10;
		return matchInfoDao.getViewList(startIndex,endIndex);
	}
}

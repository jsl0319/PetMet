package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.MatchInfoDao;
import com.petmet.web.dao.jdbc.JdbcMatchInfoDao;
import com.petmet.web.entity.MatchInfoView;

public class MatchInfoService {
	MatchInfoDao matchInfoDao = new JdbcMatchInfoDao();

	public List<MatchInfoView> getViewList(){
		return matchInfoDao.getViewList(0,0);
	}

}

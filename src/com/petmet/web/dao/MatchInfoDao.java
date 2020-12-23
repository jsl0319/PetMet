package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.MatchInfoView;


public interface MatchInfoDao {
	int insert();
	int delete();
	int update();
	
	List<MatchInfoView> getViewList();
	List<MatchInfoView> getViewList(int startIndex, int endIndex);
	


}

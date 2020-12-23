package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Admin;
import com.petmet.web.entity.MatchInfoView;
import com.petmet.web.entity.ReviewView;

public interface AdminDao {

	Admin get(String aid);

	List<MatchInfoView> getMatchInfo();
	List<ReviewView> getReview();

}

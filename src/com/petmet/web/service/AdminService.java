package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.AdminDao;
import com.petmet.web.dao.jdbc.JdbcAdminDao;
import com.petmet.web.entity.Admin;
import com.petmet.web.entity.MatchInfoView;
import com.petmet.web.entity.ReviewView;


public class AdminService {
	
private AdminDao adminDao;
	
	public AdminService() {
		adminDao = new JdbcAdminDao();
	}

	public boolean isVaild(String aid, String pwd) {
		Admin admin = adminDao.get(aid);
		if(admin == null) // 회원이 아닌 경우
			return false;
		else if(!(admin.getPwd().equals(pwd))) 
			return false;
		return true;
	}
	
	public List<MatchInfoView> getMatchInfo() {
		return adminDao.getMatchInfo();
	}

	public List<ReviewView> getReview() {
		return adminDao.getReview();
	}

	


}

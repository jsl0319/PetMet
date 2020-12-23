package com.petmet.web.service;

import com.petmet.web.dao.AdminDao;
import com.petmet.web.dao.jdbc.JdbcAdminDao;
import com.petmet.web.entity.Admin;


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
	

	


}

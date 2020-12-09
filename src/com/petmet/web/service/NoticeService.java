package com.petmet.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petmet.web.dao.jdbc.JdbcNoticeDao;
import com.petmet.web.dao.NoticeDao;
import com.petmet.web.entity.Notice;

public class NoticeService {
	private NoticeDao noticeDao;
	
	public NoticeService() {
		noticeDao = new JdbcNoticeDao();
	}
	

	public List<Notice> getList() {
		return noticeDao.getList();
	}

	// --------------------------------------------
	public Notice get(int id) { 
		return noticeDao.get(id);
	
	}

	// -----------------------------------------
	public int insert(Notice notice) {
		return noticeDao.insert(notice);
	}

	// ----------------------------
	public int update(Notice notice) {
		return noticeDao.update(notice);

	}

	/// -----------------------------------
	public int delet(int id) {
		return noticeDao.delet(id);
	}


}

package com.petmet.web.service;


import java.util.List;

import com.petmet.web.dao.NoticeDao;
import com.petmet.web.dao.jdbc.JdbcNoticeDao;
import com.petmet.web.entity.Notice;

public class NoticeService {
	private NoticeDao noticeDao;
	
	public NoticeService() {
		noticeDao = new JdbcNoticeDao();
	}
	

//	public List<Notice> getList( ) {
//		return noticeDao.getList();
//	}

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
	public int delete(int id) {
		return noticeDao.delete(id);
	}


	public List<Notice> getList(String query, String startDate, String endDate,
			int page, int num) {
		// TODO Auto-generated method stub
		return noticeDao.getList(query,startDate,endDate,
			page,num);
	}


	public int delNoticeAll(int[] ids) {
		
		return noticeDao.getdelNotceAll(ids);
	}


	public int getLastId() {
	Notice n =noticeDao.getLastId();
	
		if(n==null)
			return 0;
		else 
			return n.getId();
		
	
	}









}

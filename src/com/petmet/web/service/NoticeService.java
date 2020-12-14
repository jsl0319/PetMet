package com.petmet.web.service;

import com.petmet.web.entity.Notice;
import com.petmet.web.entity.dao.NoticeDao;
import com.petmet.web.entity.dao.jdbc.JdbcNoticeDao;

public class NoticeService {
	
	private NoticeDao noticeDao;
	
	public NoticeService() {
		noticeDao = new JdbcNoticeDao();
	}
	
	public int update(Notice notice) {
		
		return noticeDao.update(notice);
	}
}

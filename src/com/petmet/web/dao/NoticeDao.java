package com.petmet.web.dao;

import java.util.Date;
import java.util.List;


import com.petmet.web.entity.Notice;

public interface NoticeDao {
	
	int insert(Notice notice);
	int delete(int id);
	int update(Notice notice);

	Notice get(int id);

	
	

//	List<Notice> getList();
	
	List<Notice> getList(String query, String startDate, String endDate, int page, int num);

	
	int getdelNotceAll(int[] ids);
	Notice getLastId();

}

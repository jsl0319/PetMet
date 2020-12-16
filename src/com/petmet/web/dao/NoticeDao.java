package com.petmet.web.dao;

import java.util.Date;
import java.util.List;


import com.petmet.web.entity.Notice;

public interface NoticeDao {
	
	int insert(Notice notice);
	int delete(int id);
	int update(Notice notice);

	Notice get(int id);

	
	
	List<Notice> getList(int category, String searchContent, boolean pub, boolean nonPub, Date startDate, Date endDate, int page);
	List<Notice> pubList(List<Integer> ids);
	int deleteList(List<Integer> ids);
	
	List<Notice> getList();


}

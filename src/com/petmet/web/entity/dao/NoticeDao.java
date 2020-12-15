package com.petmet.web.entity.dao;

import java.util.Date;
import java.util.List;

import com.petmet.web.entity.Notice;

public interface NoticeDao {
	
	int insert(Notice notice);
	int delete(int id);
	int update(Notice notice);
	Notice get(int id);
	int deleteList(List<Integer> ids);
	List<Notice> getList(int category, String searchContent, int page);
	List<Notice> getList(int pubId, boolean pub, boolean nonPub, int page);
	List<Notice> getList(int pubId, boolean pub, int page);
	List<Notice> getList(Date startDate, Date endDate, int page);
	List<Notice> getList(int category, String searchContent, boolean pub, boolean nonPub, Date startDate, Date endDate, int page);
	List<Notice> pubList(List<Integer> ids);
	List<Notice> getList(int page);

}

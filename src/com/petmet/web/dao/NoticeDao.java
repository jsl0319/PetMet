package com.petmet.web.dao;

import java.util.Date;
import java.util.List;

import com.petmet.web.entity.Notice;

public interface NoticeDao {
	int insert(Notice notice);
	int update(Notice notice);
	int delet(int id);
	
	Notice get(int id);
	List<Notice> getList();
	
	

//   List<Notice> getList(int page);
//   List<Notice> getList(boolean pub, int page);
//  List<Notice> getList(int category, String searchContent, int page);
//  List<Notice> getList(boolean pub, boolean nonPub, int page);
//  List<Notice> getList(Date startDate, Date endDate, int page);
//  List<Notice> getList(int category, String searchContent, boolean pub, boolean nonPub, Date startDate, Date endDate, int page);
//
//  List<Notice> deleteList(List<Integer> ids);
//  List<Notice> pubList(List<Integer> ids);


}

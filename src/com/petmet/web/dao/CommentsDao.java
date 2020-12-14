package com.petmet.web.dao;

import java.util.Date;
import java.util.List;

import com.petmet.web.entity.Comments;

public interface CommentsDao {
	int insert(Comments comment);

	int update(Comments comment);

	int delete(int id);

	Comments get(int id);

	List<Comments> getList();

	List<Comments> getList(int page);

	List<Comments> getList(int category, String searchContent, int page);

	List<Comments> getList(int boardCategory, int page);

	List<Comments> getList(Date startDate, Date endDate, int page);

	List<Comments> getList(int category, String searchContent, int boardCategory, int page);

	List<Comments> getList(int category, String searchContent, Date startDate, Date endDate, int page);

	List<Comments> getList(int boardCategory, Date startDate, Date endDate, int page);

	List<Comments> getList(int category, String searchContent, int boardCategory, Date startDate, Date endDate,
			int page);

	int deleteList(List<Integer> ids);

	Comments getPrev(int id);

	Comments getNext(int id);

}

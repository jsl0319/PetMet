package com.petmet.web.service;

import java.util.Date;
import java.util.List;

import com.petmet.web.dao.CommentsDao;
import com.petmet.web.dao.jdbc.JdbcCommentsDao;
import com.petmet.web.entity.Comments;

public class CommentsService {
	private CommentsDao commentsDao;
	
	//---------------------------------- Constructor ----------------------------------
	public CommentsService() {
		commentsDao = new JdbcCommentsDao();
	}
	
	//---------------------------------- Functions ----------------------------------
	public int insert(Comments comment) {
		return commentsDao.insert(comment);
	}

	public int update(Comments comment) {
		return commentsDao.update(comment);
	}

	public int delete(int id) {
		return commentsDao.delete(id);
	}

	public Comments get(int id) {
		return commentsDao.get(id);
	}

	public List<Comments> getList() {
		return commentsDao.getList();
	}

	public List<Comments> getList(int page) {
		return commentsDao.getList(page);
	}

	public List<Comments> getList(int category, String searchContent, int page) {
		return commentsDao.getList(category, searchContent, page);
	}

	public List<Comments> getList(int boardCategory, int page) {
		return commentsDao.getList(boardCategory, page);
	}

	public List<Comments> getList(Date startDate, Date endDate, int page) {
		return commentsDao.getList(startDate, endDate, page);
	}

	public List<Comments> getList(int category, String searchContent, int boardCategory, int page) {
		return commentsDao.getList(category, searchContent, boardCategory, page);
	}

	public List<Comments> getList(int category, String searchContent, Date startDate, Date endDate, int page) {
		return commentsDao.getList(category, searchContent, startDate, endDate, page);
	}

	public List<Comments> getList(int boardCategory, Date startDate, Date endDate, int page) {
		return commentsDao.getList(boardCategory, startDate, endDate, page);
	}

	public List<Comments> getList(int category, String searchContent, int boardCategory, Date startDate, Date endDate,
			int page) {
		return commentsDao.getList(category, searchContent, boardCategory, startDate, endDate, page);
	}

	public int deleteList(List<Integer> ids) {
		return commentsDao.deleteList(ids);
	}

	public Comments getPrev(int id) {
		return commentsDao.getPrev(id);
	}

	public Comments getNext(int id) {
		return commentsDao.getNext(id);
	}

}

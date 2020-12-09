package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.CommentReportDao;
import com.petmet.web.dao.jdbc.JdbcCommentReportDao;
import com.petmet.web.entity.CommentReport;

public class CommentReportService {
	private CommentReportDao commentReportDao;
	
	//---------------------------------- Constructor ----------------------------------
	public CommentReportService() {
		commentReportDao = new JdbcCommentReportDao();
	}
	
	//---------------------------------- Functions ----------------------------------
	public int insert(CommentReport commentReport) {

		return commentReportDao.insert(commentReport);
	}

	public int update(CommentReport commentReport) {

		return commentReportDao.update(commentReport);
	}

	public int delete(int id) {

		return commentReportDao.delete(id);
	}

	public CommentReport get(int id) {

		return commentReportDao.get(id);
	}

	public List<CommentReport> getList() {

		return commentReportDao.getList();
	}

	public List<CommentReport> getList(int boardId) {

		return commentReportDao.getList(boardId);
	}

}

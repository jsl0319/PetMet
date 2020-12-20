package com.petmet.web.service;

import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardCategoryDao;
import com.petmet.web.dao.BoardDao;
import com.petmet.web.dao.CommentReportDao;
import com.petmet.web.dao.CommentsDao;
import com.petmet.web.dao.jdbc.JdbcBoardCategoryDao;
import com.petmet.web.dao.jdbc.JdbcBoardDao;
import com.petmet.web.dao.jdbc.JdbcCommentReportDao;
import com.petmet.web.dao.jdbc.JdbcCommentsDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardReport;
import com.petmet.web.entity.CommentReport;
import com.petmet.web.entity.CommentReportView;
import com.petmet.web.entity.CommentView;
import com.petmet.web.entity.Comments;

public class CommentReportService {
	private CommentReportDao commentReportDao;

	// ---------------------------------- Constructor ----------------------------------
	public CommentReportService() {
		commentReportDao = new JdbcCommentReportDao();
	}

	// ---------------------------------- Functions ----------------------------------
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

	// -------------- getList --------------
	public List<CommentReport> getList() {
		return getList(null, null, null, null, null, 1, 20);
	}
	
	// ---- getList 최종
	public List<CommentReport> getList(String selectBox, String query, String boardCategory, String startDate,
			String endDate, int page, int size) {
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return commentReportDao.getList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------

	public int deleteList(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++, result++) {
			int id = ids[i];
			commentReportDao.delete(id);
		}
		return result;
	}
	
	public int deleteCommentList(int[] ids) {
		int result = 0;
		CommentsDao commentDao = new JdbcCommentsDao();
		
		for (int i = 0; i < ids.length; i++, result++) {
			int id = ids[i];
			commentDao.delete(id);
		}
		return result;
	}

	public CommentReportView getPrev(int id) {
		String subQuery = "WHERE NUM = (SELECT NUM FROM COMMENT_REPORT_VIEW WHERE ID = " + id + ") + 1";
		return commentReportDao.getView(subQuery);
	}

	public CommentReportView getNext(int id) {
		String subQuery = "WHERE NUM = (SELECT NUM FROM COMMENT_REPORT_VIEW WHERE ID = " + id + ") - 1";
		return commentReportDao.getView(subQuery);
	}

	public Board getBoard(int boardId) {
		BoardDao boardDao = new JdbcBoardDao();
		return boardDao.get(boardId);
	}

	public List<BoardCategory> getCategoryList() {
		BoardCategoryDao categoryDao = new JdbcBoardCategoryDao();
		return categoryDao.getList();
	}

	public Comments getComment(int id) {
		CommentsDao commentDao = new JdbcCommentsDao();
		return commentDao.get(id);
	}
	
	public List<CommentReport> getListByCommentId(int commentId){
		return commentReportDao.getListByCommentId(commentId);
	}
	
	public int getTotalPage(String field, String query, String board, String startDate, String endDate, int page, int size) {
		int records = 0;

		List<CommentReportView> list = commentReportDao.getViewList(field, query, board, startDate, endDate);
		for (CommentReportView c : list)
			records++;

		int pages = (int) Math.ceil(records / (float) size);

		return pages;
	}

	// -------------- getViewList --------------
	public List<CommentReportView> getViewList() {
		return getViewList(null, null, null, null, null, 1, 20);
	}
	
	// ---- getViewList 최종
	public List<CommentReportView> getViewList(String selectBox, String query, String boardCategory, String startDate,
			String endDate, int page, int size) {
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return commentReportDao.getViewList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------

}

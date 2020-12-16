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
import com.petmet.web.entity.Comments;

public class CommentReportService {
	private CommentReportDao commentReportDao;

	// ---------------------------------- Constructor
	// ----------------------------------
	public CommentReportService() {
		commentReportDao = new JdbcCommentReportDao();
	}

	// ---------------------------------- Functions
	// ----------------------------------
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

	public List<CommentReport> getList(int page) {
		return getList(null, null, null, null, null, page, 20);
	}

	public List<CommentReport> getList(int page, int size) {
		return getList(null, null, null, null, null, page, size);
	}

	public List<CommentReport> getList(String selectBox, String query) {
		return getList(selectBox, query, null, null, null, 1, 20);
	}

	public List<CommentReport> getList(String boardCategory) {
		return getList(null, null, boardCategory, null, null, 1, 20);
	}

	public List<CommentReport> getList(Date startDate, Date endDate) {
		return getList(null, null, null, startDate, endDate, 1, 20);
	}

	public List<CommentReport> getList(String selectBox, String query, int page) {
		return getList(selectBox, query, null, null, null, page, 20);
	}

	public List<CommentReport> getList(String selectBox, String query, int page, int size) {
		return getList(selectBox, query, null, null, null, page, size);
	}

	public List<CommentReport> getList(String boardCategory, int page) {
		return getList(null, null, boardCategory, null, null, page, 20);
	}

	public List<CommentReport> getList(String boardCategory, int page, int size) {
		return getList(null, null, boardCategory, null, null, page, size);
	}

	public List<CommentReport> getList(Date startDate, Date endDate, int page) {
		return getList(null, null, null, startDate, endDate, page, 20);
	}

	public List<CommentReport> getList(Date startDate, Date endDate, int page, int size) {
		return getList(null, null, null, startDate, endDate, page, size);
	}

	public List<CommentReport> getList(String selectBox, String query, String boardCategory, int page) {
		return getList(selectBox, query, boardCategory, null, null, page, 20);
	}

	public List<CommentReport> getList(String selectBox, String query, String boardCategory, int page, int size) {
		return getList(selectBox, query, boardCategory, null, null, page, size);
	}

	public List<CommentReport> getList(String boardCategory, Date startDate, Date endDate, int page) {
		return getList(null, null, boardCategory, startDate, endDate, page, 20);
	}

	public List<CommentReport> getList(String boardCategory, Date startDate, Date endDate, int page, int size) {
		return getList(null, null, boardCategory, startDate, endDate, page, size);
	}

	public List<CommentReport> getList(String selectBox, String query, Date startDate, Date endDate, int page) {
		return getList(selectBox, query, null, startDate, endDate, page, 20);
	}

	public List<CommentReport> getList(String selectBox, String query, Date startDate, Date endDate, int page,
			int size) {
		return getList(selectBox, query, null, startDate, endDate, page, size);
	}

	// ---- getList 최종
	public List<CommentReport> getList(String selectBox, String query, String boardCategory, Date startDate,
			Date endDate, int page, int size) {
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

	public CommentReport getPrev(int id) {
		return commentReportDao.get(id - 1);
	}

	public CommentReport getNext(int id) {
		return commentReportDao.get(id + 1);
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

	// -------------- getViewList --------------
	public List<CommentReportView> getViewList() {
		return getViewList(null, null, null, null, null, 1, 20);
	}

	public List<CommentReportView> getViewList(int page) {
		return getViewList(null, null, null, null, null, page, 20);
	}

	public List<CommentReportView> getViewList(int page, int size) {
		return getViewList(null, null, null, null, null, page, size);
	}

	public List<CommentReportView> getViewList(String selectBox, String query) {
		return getViewList(selectBox, query, null, null, null, 1, 20);
	}

	public List<CommentReportView> getViewList(String boardCategory) {
		return getViewList(null, null, boardCategory, null, null, 1, 20);
	}

	public List<CommentReportView> getViewList(Date startDate, Date endDate) {
		return getViewList(null, null, null, startDate, endDate, 1, 20);
	}

	public List<CommentReportView> getViewList(String selectBox, String query, int page) {
		return getViewList(selectBox, query, null, null, null, page, 20);
	}

	public List<CommentReportView> getViewList(String selectBox, String query, int page, int size) {
		return getViewList(selectBox, query, null, null, null, page, size);
	}

	public List<CommentReportView> getViewList(String boardCategory, int page) {
		return getViewList(null, null, boardCategory, null, null, page, 20);
	}

	public List<CommentReportView> getViewList(String boardCategory, int page, int size) {
		return getViewList(null, null, boardCategory, null, null, page, size);
	}

	public List<CommentReportView> getViewList(Date startDate, Date endDate, int page) {
		return getViewList(null, null, null, startDate, endDate, page, 20);
	}

	public List<CommentReportView> getViewList(Date startDate, Date endDate, int page, int size) {
		return getViewList(null, null, null, startDate, endDate, page, size);
	}

	public List<CommentReportView> getViewList(String selectBox, String query, String boardCategory, int page) {
		return getViewList(selectBox, query, boardCategory, null, null, page, 20);
	}

	public List<CommentReportView> getViewList(String selectBox, String query, String boardCategory, int page,
			int size) {
		return getViewList(selectBox, query, boardCategory, null, null, page, size);
	}

	public List<CommentReportView> getViewList(String boardCategory, Date startDate, Date endDate, int page) {
		return getViewList(null, null, boardCategory, startDate, endDate, page, 20);
	}

	public List<CommentReportView> getViewList(String boardCategory, Date startDate, Date endDate, int page, int size) {
		return getViewList(null, null, boardCategory, startDate, endDate, page, size);
	}

	public List<CommentReportView> getViewList(String selectBox, String query, Date startDate, Date endDate, int page) {
		return getViewList(selectBox, query, null, startDate, endDate, page, 20);
	}

	public List<CommentReportView> getViewList(String selectBox, String query, Date startDate, Date endDate, int page,
			int size) {
		return getViewList(selectBox, query, null, startDate, endDate, page, size);
	}

	// ---- getViewList 최종
	public List<CommentReportView> getViewList(String selectBox, String query, String boardCategory, Date startDate,
			Date endDate, int page, int size) {
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return commentReportDao.getViewList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------
}

package com.petmet.web.service;

import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardCategoryDao;
import com.petmet.web.dao.BoardDao;
import com.petmet.web.dao.CommentsDao;
import com.petmet.web.dao.jdbc.JdbcBoardCategoryDao;
import com.petmet.web.dao.jdbc.JdbcBoardDao;
import com.petmet.web.dao.jdbc.JdbcCommentsDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardView;
import com.petmet.web.entity.CommentView;
import com.petmet.web.entity.Comments;

public class CommentsService {
	private CommentsDao commentsDao;

	// ---------------------------------- Constructor ----------------------------------
	public CommentsService() {
		commentsDao = new JdbcCommentsDao();
	}

	// ---------------------------------- Functions ----------------------------------
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

	// -------------- getList --------------
	public List<Comments> getList() {
		return getList(null, null, null, null, null, 1, 20);
	}

	// ---- getList 최종
	public List<Comments> getList(String selectBox, String query, String boardCategory, String startDate, String endDate,
			int page, int size) {
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return commentsDao.getList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------

	public int deleteList(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++, result++) {
			int id = ids[i];
			commentsDao.delete(id);
		}
		return result;
	}

	public CommentView getPrev(int id) {
		String subQuery = "WHERE NUM = (SELECT NUM FROM COMMENT_VIEW WHERE ID = " + id + ") + 1";
		return commentsDao.getView(subQuery);
	}

	public CommentView getNext(int id) {
		String subQuery = "WHERE NUM = (SELECT NUM FROM COMMENT_VIEW WHERE ID = " + id + ") - 1";
		return commentsDao.getView(subQuery);
	}
	
	public Board getBoard(int boardId) {
		BoardDao boardDao = new JdbcBoardDao();
		return boardDao.get(boardId);
	}
	
	public List<BoardCategory> getCategoryList(){
		BoardCategoryDao categoryDao = new JdbcBoardCategoryDao();
		return categoryDao.getList();
	}
	
	public int getTotalPage(String field, String query, String board, String startDate, String endDate, int page, int size) {
		int records = 0;

		List<CommentView> list = commentsDao.getViewList(field, query, board, startDate, endDate);
		for (CommentView c : list)
			records++;

		int pages = (int) Math.ceil(records / (float) size);

		return pages;
	}
	
	// -------------- getViewList --------------
	public List<CommentView> getViewList() {
		return getViewList(null, null, null, null, null, 1, 20);
	}

	// ---- getViewList 최종
	public List<CommentView> getViewList(String selectBox, String query, String boardCategory, String startDate,
			String endDate, int page, int size) {
		// page & size
		int startIndex = 1 + (page - 1) * size;
		int endIndex = size * page;

		return commentsDao.getViewList(selectBox, query, boardCategory, startDate, endDate, startIndex, endIndex);
	}
	// ---------------------------------------

}

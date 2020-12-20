package com.petmet.web.dao;

import java.util.Date;
import java.util.List;

import com.petmet.web.entity.CommentView;
import com.petmet.web.entity.Comments;

public interface CommentsDao {
	int insert(Comments comment);
	int update(Comments comment);
	int delete(int id);
	Comments get(int id);

	List<Comments> getList(String selectBox, String query, String boardCategory, String startDate, String endDate, int startIndex, int endIndex);
	CommentView getView(String subQuery);
	List<CommentView> getViewList(String field, String query, String board, String startDate, String endDate);
	List<CommentView> getViewList(String selectBox, String query, String boardCategory, String startDate, String endDate, int startIndex, int endIndex);
}

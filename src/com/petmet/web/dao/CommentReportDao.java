package com.petmet.web.dao;

import java.util.Date;
import java.util.List;

import com.petmet.web.entity.CommentReport;
import com.petmet.web.entity.CommentReportView;
import com.petmet.web.entity.CommentView;

public interface CommentReportDao {
	int insert(CommentReport commentReport);
	int update(CommentReport commentReport);
	int delete(int id);
	CommentReport get(int id);

	List<CommentReport> getList(String selectBox, String query, String boardCategory, String startDate, String endDate, int startIndex, int endIndex);
	List<CommentReportView> getViewList(String field, String query, String board, String startDate, String endDate);
	List<CommentReportView> getViewList(String selectBox, String query, String boardCategory, String startDate, String endDate, int startIndex, int endIndex);
	List<CommentReport> getListByCommentId(int commentId);
}

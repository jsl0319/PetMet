package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.CommentReport;

public interface CommentReportDao {
	int insert(CommentReport commentReport);

	int update(CommentReport commentReport);

	int delete(int id);

	CommentReport get(int id);

	List<CommentReport> getList();

	List<CommentReport> getList(int boardId);

}

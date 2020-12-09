package com.petmet.web.dao;

import java.util.Date;
import java.util.List;

import com.petmet.web.entity.Board;
import com.petmet.web.entity.Comments;

public interface BoardDao {
	int insert(Board board);

	int update(Board board);

	int delete(int id);

	Board get(int id);

	List<Board> getList();

	List<Board> getList(int page);

	List<Board> getList(int category, String searchContent, int page);

	List<Board> getList(int boardCategory, int page);

	List<Board> getList(Date startDate, Date endDate, int page);

	List<Board> getList(int category, String searchContent, int boardCategory, int page);

	List<Board> getList(int category, String searchContent, Date startDate, Date endDate, int page);

	List<Board> getList(int boardCategory, Date startDate, Date endDate, int page);

	List<Board> getList(int category, String searchContent, int boardCategory, Date startDate, Date endDate, int page);

	int deleteList(List<Integer> ids);

	Board getPrev(int id);

	Board getNext(int id);
}

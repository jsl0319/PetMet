package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardCategoryView;

public interface BoardCategoryDao {
	int insert(BoardCategory boardCategory);
	int update(BoardCategory boardCategory);
	int delete(int id);
	BoardCategory get(int id);

	List<BoardCategory> getList(int startIndex, int endIndex);
	List<BoardCategoryView> getViewList(int startIndex, int endIndex);
}
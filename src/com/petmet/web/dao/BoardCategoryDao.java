package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.BoardCategory;

public interface BoardCategoryDao {
	int insert(BoardCategory boardCategory);

	int update(BoardCategory boardCategory);

	int delete(int id);

	BoardCategory get(int id);

	List<BoardCategory> getList();
}

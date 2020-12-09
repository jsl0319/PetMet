package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Matching;

public interface MatchingDao {
	int insert(Matching matching);

	int update(Matching matching);

	int delete(int id);

	Matching get(int id);

	List<Matching> getList();
}

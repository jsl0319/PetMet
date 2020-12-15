package com.petmet.web.entity.dao;

import java.util.List;

import com.petmet.web.entity.Member;

public interface MemberDao {
	int insert(Member member);
	List<Member> getList();
	Member get(int id);
	int update(Member member);
	int delete(int id);
}

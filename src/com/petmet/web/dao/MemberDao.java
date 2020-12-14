package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Member;

public interface MemberDao {
	int insert(Member member);
	Member get(int id);
	int update(Member member);
	int delete(int id);
	List<Member> getList();
}

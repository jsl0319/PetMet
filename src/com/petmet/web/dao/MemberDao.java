package com.petmet.web.dao;

import java.util.List;

import com.petmet.web.entity.Member;
import com.petmet.web.entity.MemberView;

public interface MemberDao {
//	int insert(Member member);
//	Member get(int id);
//	int update(Member member);
//	int delete(int id);
	List<Member> getList(String field, String query, String startDate, String endDate, int startIndex, int endIndex);
	MemberView get(int id);
	int getCount(String field, String query, String startDate, String endDate);
}

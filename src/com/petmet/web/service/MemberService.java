package com.petmet.web.service;

import java.util.ArrayList;
import java.util.List;

import com.petmet.web.entity.Member;
import com.petmet.web.dao.MemberDao;
import com.petmet.web.dao.jdbc.JdbcMemberDao;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new JdbcMemberDao();
	}

	public List<Member> getList() {
		String sql = "SELECT * FROM MEMBER";

		List<Member> list = new ArrayList<>();

		return list;
	}

	public Member get(int id) {

		
		return new Member();
	}


	public int insert(Member member) {
		
		return 0;

	}

	public int update(Member member) {


		return memberDao.update(member);
		
	}
	
	public int delete(int id) {
		
		return 0;
	}
}

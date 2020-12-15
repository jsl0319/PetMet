package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.MemberDao;
import com.petmet.web.dao.jdbc.JdbcMemberDao;
import com.petmet.web.entity.Member;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new JdbcMemberDao();
	}
	
	public int insert(Member member) {
		int result=0;
		
		return result;
		
	}
	
	public Member get(int id) {
		Member member = memberDao.get(id);
		return member;
	}
	
	public List<Member> getList() {
		List<Member> list = memberDao.getList();
		return list;
	}

}

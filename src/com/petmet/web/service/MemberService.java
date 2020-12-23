package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.MemberDao;
import com.petmet.web.dao.jdbc.JdbcMemberDao;
import com.petmet.web.entity.Member;
import com.petmet.web.entity.MemberView;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new JdbcMemberDao();
	}
	

	public List<Member> getList(String field, String query, String startDate, String endDate, int page, int num) {
		int startIndex = 1+(page-1)*num;     
		int endIndex = page*num;	 		
		List<Member> list = memberDao.getList(field, query, startDate, endDate, startIndex, endIndex);
		return list;
	}


	public MemberView get(int id) {
		// TODO Auto-generated method stub
		return memberDao.get(id);
	}


	public int getCount(String field, String query, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return memberDao.getCount(field,query,startDate,endDate);
	}


	public boolean isVaild(String mid, String pwd) {
		Member member = memberDao.get(mid);
		if(member == null) // 회원이 아닌 경우
			return false;
		else if(!(member.getPwd().equals(pwd))) 
			return false;
		return true;
	}


	public String getNickname(String mid) {
		Member member = memberDao.get(mid);
		return member.getNickname();
		
	}

}

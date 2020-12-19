package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.MatchingDao;
import com.petmet.web.dao.MemberDao;
import com.petmet.web.dao.jdbc.JdbcMatchingDao;
import com.petmet.web.dao.jdbc.JdbcMemberDao;
import com.petmet.web.entity.Matching;
import com.petmet.web.entity.MatchingView;
import com.petmet.web.entity.Member;
import com.petmet.web.entity.MemberView;

public class MatchingService {
	private MatchingDao matchingDao;

	public MatchingService() {
		matchingDao = new JdbcMatchingDao();
	}

	public List<MatchingView> getList(int field,String startDate, String endDate, int page, int num) {
		int startIndex = 1 + (page - 1) * num;
		int endIndex = page * num;
		List<MatchingView> list = matchingDao.getList(field,startDate,endDate,startIndex, endIndex);
		return list;
	}

	public List<Matching> getReportList(String field, String query, int page, int num) {
		int startIndex = 1 + (page - 1) * num;
		int endIndex = page * num;
		List<Matching> list = matchingDao.getReportList(field, query,startIndex, endIndex);
		return list;
	}


	public Matching getReport(int id) {
		
		return matchingDao.getReport(id);
	}

	public MatchingView get(int id) {
		
		return matchingDao.get(id);
	}
}

package com.petmet.web.service;

import java.util.List;

import com.petmet.web.dao.ReportedFeedViewDao;
import com.petmet.web.dao.jdbc.JdbcReportedFeedViewDao;
import com.petmet.web.entity.ReportedFeedView;

public class ReportedFeedViewService {

		private ReportedFeedViewDao reportedFeedViewDao; 
		
		public ReportedFeedViewService() {
			reportedFeedViewDao = new JdbcReportedFeedViewDao();
		}
		public List<ReportedFeedView> getList() {
		      
			return reportedFeedViewDao.getList();
		}
		
		public List<ReportedFeedView> getList(int page) {
		      
			return reportedFeedViewDao.getList(page);
		}

		public ReportedFeedView get(int id) {
			
			return reportedFeedViewDao.get(id);
		}

		public int insert(ReportedFeedView ReportedFeedView) {
			
			return reportedFeedViewDao.insert(ReportedFeedView);
		}

		public int update(ReportedFeedView ReportedFeedView) {
			int result = 0;
			
			result = reportedFeedViewDao.update(ReportedFeedView);
			return result;
		}

		public int delete(int id) {
			int result = 0;
			
			result = reportedFeedViewDao.delete(id);
			return result;
			
		}
		
	}


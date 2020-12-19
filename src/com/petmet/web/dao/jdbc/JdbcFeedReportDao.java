package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.petmet.web.dao.FeedReportDao;
import com.petmet.web.entity.FeedReport;
import com.petmet.web.entity.ReportedFeedView;

public class JdbcFeedReportDao implements FeedReportDao{

	@Override
	public int insert(FeedReport feedReport) {
		  int result = 0;
		
		  String sql = "INSERT INTO FEED_REPORT(MEM_ID, FEED_ID, CONTENT) VALUES(?,?,?)";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      List<FeedReport> list = new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          st.setString(1, feedReport.getMemId());
	          st.setString(2, feedReport.getFeedId());
	          st.setString(3, feedReport.getContent());
	          
	          result = st.executeUpdate();
	          st.close();
	          con.close();
	          
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			return result;
	}

	@Override
	public int update(FeedReport feedReport) {
		  int result = 0;
		
		  String sql = "UPDATE FEED_REPORT SET CONTENT=? WHERE ID=?";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;


	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          
	          st.setString(1, feedReport.getContent());
	          st.setInt(2, feedReport.getId());
//	          st.setString(1, feedReport.getMemId());
//	          st.setString(2, feedReport.getFeedId());
//	          st.setInt(4, feedReport.getId());
	          
	          result = st.executeUpdate();
	          st.close();
	          con.close();
	          
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			return result;
	}

	@Override
	public int delete(int id) {
		  int result = 0;
		
		  String sql = "DELETE FROM FEED_REPORT WHERE ID=?";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;


	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          
	          st.setInt(1,id);
	          
	          result = st.executeUpdate();
	          st.close();
	          con.close();
	          
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			return result;
	}

	@Override
	public FeedReport get(int id) {
		FeedReport fr = null;
		
   		  String sql = "SELECT * FROM FEED_REPORT WHERE ID ="+id;
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      List<FeedReport> list= new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          Statement st = con.createStatement();
	          ResultSet rs = st.executeQuery(sql);
	         
	         
	         if(rs.next()){

	        	String memId = rs.getNString("mem_id");
	        	String feedId = rs.getString("feed_id");
	        	Date repoDate = rs.getDate("repo_date");
	        	String content = rs.getNString("content");
	        	
	        	fr = new FeedReport(id, 0 ,memId, feedId, repoDate, content);
	        	
	         }
	         
	         rs.close();
	         st.close();
	         con.close();
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			return fr;
	}
	
	
	

//	@Override
//	public List<FeedReport> getList() {
//		
//		  String sql = "SELECT * FROM FEED_REPORT";
//		  String url = DBContext.URL;
//		  String uid = DBContext.UID;
//		  String pwd = DBContext.PWD;
//
//	      List<FeedReport> list= new ArrayList<>();
//
//	      try {
//	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
//	          Connection con = DriverManager.getConnection(url,uid,pwd);
//	          Statement st = con.createStatement();
//	          ResultSet rs = st.executeQuery(sql);
//	         
//	         
//	         while(rs.next()){
//	        	int id = rs.getInt("id");
//	        	String memId = rs.getNString("mem_id");
//	        	String feedId = rs.getString("feed_id");
//	        	Date repoDate = rs.getDate("repo_date");
//	        	String content = rs.getNString("content");
//	        	
//	        	FeedReport fr = new FeedReport(id, memId, feedId, repoDate, content);
//	        	
//	        	list.add(fr);
//	         }
//	         
//	         rs.close();
//	         st.close();
//	         con.close();
//	         
//	         
//	      } catch (SQLException e) {
//	         e.printStackTrace();
//	      } catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//			return list;
//	}

	@Override
	public List<FeedReport> getList(String field, String query, String startDate, String endDate, int startIndex,
			int endIndex) {
		  String sql = "SELECT * FROM "
		  		+ "(SELECT ROWNUM NUM, FR.* FROM FEED_REPORT FR "
		  		+ "WHERE "+field+" LIKE ?  AND "
		  		+ "REPO_DATE>? AND "
		  		+ "REPO_DATE<(SELECT TO_DATE(?,'YY-MM-DD')+1 FROM DUAL)) "
		  		+ "WHERE NUM BETWEEN ? AND ?";
		  
		  
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      List<FeedReport> list= new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          
	            st.setString(1, "%"+query+"%");
				st.setString(2, startDate);
				st.setString(3, endDate);
				st.setInt(4, startIndex);
				st.setInt(5, endIndex);
	           
	           ResultSet rs = st.executeQuery();

	         
	         while(rs.next()){
	        	int id = rs.getInt("id");
	        	int num = rs.getInt("num");
	        	String memId = rs.getNString("mem_id");
	        	String feedId = rs.getString("feed_id");
	        	Date repoDate = rs.getDate("repo_date");
	        	String content = rs.getNString("content");
	        	
	        	FeedReport fr = new FeedReport(id, num, memId, feedId, repoDate, content);
	        	
	        	list.add(fr);
	         }
	         
	         rs.close();
	         st.close();
	         con.close();
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			return list;
	}

	@Override
	public List<ReportedFeedView> getViewList(String field, String query, int startIndex, int endIndex) {
		
		String sql = "SELECT * "
				+ "FROM(SELECT * FROM "
				+ "REPORTED_FEED_VIEW "
				+ "WHERE "+field+" LIKE ?)"
				+ "WHERE ROWNUM BETWEEN ? AND ?";
		  
		  
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      List<ReportedFeedView> list = new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          
	           st.setNString(1, '%'+query+'%');
	           st.setInt(2, startIndex);
	           st.setInt(3, endIndex);
	           
	           ResultSet rs = st.executeQuery();

	         
	         while(rs.next()){
	        	int id = rs.getInt("id");
	        	int num = rs.getInt("num");
	        	String reportedId = rs.getNString("reported_id");
	        	String files = rs.getNString("files");
	        	String content = rs.getNString("content");
	        	int repoCnt = rs.getInt("repo_cnt");
	        	String action = rs.getNString("action");
	        	
	        	ReportedFeedView fr = new ReportedFeedView(id, num, reportedId,
	        			files, content, repoCnt, action);
	        	
	        	list.add(fr);
	         }
	         
	         rs.close();
	         st.close();
	         con.close();
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			return list;
	}

	@Override
	public FeedReport getLast() {
		FeedReport fr = null;
		
 		  String sql = "SELECT * FROM FEED_REPORT WHERE ID = (SELECT MAX(ID) FROM FEED_REPORT)";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      List<FeedReport> list= new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          Statement st = con.createStatement();
	          ResultSet rs = st.executeQuery(sql);
	         
	         
	         if(rs.next()){
	        	int id = rs.getInt("id");
	        	int num = rs.getInt("num");
	        	String memId = rs.getNString("mem_id");
	        	String feedId = rs.getString("feed_id");
	        	Date repoDate = rs.getDate("repo_date");
	        	String content = rs.getNString("content");
	        	
	        	fr = new FeedReport(id, num,memId, feedId, repoDate, content);
	        	
	         }
	         
	         rs.close();
	         st.close();
	         con.close();
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			return fr;
	}

	

}

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

public class JdbcFeedReportDao implements FeedReportDao{

	@Override
	public int insert(FeedReport feedReport) {
		  int result = 0;
		
		  String sql = "INSERT INTO FEEDREPORT(MEM_ID, FEED_ID, CONTENT) VALUES(?,?,?)";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      List<FeedReport> list = new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          st.setString(1, feedReport.getMemId());
	          st.setInt(2, feedReport.getFeedId());
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
		
		  String sql = "UPDATE FEEDREPORT SET MEM_ID=?, FEED_ID=?, CONTENT=? WHERE ID=?";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;


	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          
	          st.setString(1, feedReport.getMemId());
	          st.setInt(2, feedReport.getFeedId());
	          st.setString(3, feedReport.getContent());
	          st.setInt(4, feedReport.getId());
	          
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
		
		  String sql = "DELETE FROM FEEDREPORT WHERE ID=?";
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
		
   		  String sql = "SELECT * FROM FEEDREPORT WHERE ID ="+id;
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
	        	int feedId = rs.getInt("feed_id");
	        	Date repoDate = rs.getDate("repo_date");
	        	String content = rs.getNString("content");
	        	
	        	fr = new FeedReport(id, memId, feedId, repoDate, content);
	        	
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

	@Override
	public List<FeedReport> getList() {
		
		  String sql = "SELECT * FROM FEEDREPORT";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      List<FeedReport> list= new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          Statement st = con.createStatement();
	          ResultSet rs = st.executeQuery(sql);
	         
	         
	         while(rs.next()){
	        	int id = rs.getInt("id");
	        	String memId = rs.getNString("mem_id");
	        	int feedId = rs.getInt("feed_id");
	        	Date repoDate = rs.getDate("repo_date");
	        	String content = rs.getNString("content");
	        	
	        	FeedReport fr = new FeedReport(id, memId, feedId, repoDate, content);
	        	
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
	public List<FeedReport> getList(int page) {
		
			return getList(0);
	}

	

}

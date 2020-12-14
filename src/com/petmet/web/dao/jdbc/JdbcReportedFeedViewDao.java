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

import com.petmet.web.dao.ReportedFeedViewDao;
import com.petmet.web.entity.ReportedFeedView;

public class JdbcReportedFeedViewDao implements ReportedFeedViewDao {
	
	@Override
	public int insert(ReportedFeedView reportedFeedView) {
		
		 int result = 0;
			
		  String sql = "INSERT INTO REPORTED_FEED_VIEW(MEM_ID, REPOTED_ID, REPO_CONTENT) VALUES(?,?,?)";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;


	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          st.setString(1, reportedFeedView.getMemId());
	          st.setString(2, reportedFeedView.getReportedId());
	          st.setString(3, reportedFeedView.getRepoContent());
	          
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
	public int update(ReportedFeedView reportedFeedView) {
		int result = 0;
		
		  String sql = "UPDATE REPORTED_FEED_VIEW SET MEM_ID=?,REPORTED_ID=?, REPO_CONTENT=?, ACTION=? WHERE ID=?";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;


	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          
	          st.setString(1, reportedFeedView.getMemId());
	          st.setString(2, reportedFeedView.getReportedId());
	          st.setString(3, reportedFeedView.getRepoContent());
	          st.setString(4, reportedFeedView.getAction());
	          st.setInt(5, reportedFeedView.getId());
	          
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
		
		  String sql = "DELETE FROM REPORTED_FEED_VIEW WHERE ID=?";
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
	public ReportedFeedView get(int id) {
		ReportedFeedView fr = null;
		
 		  String sql = "SELECT * FROM REPORTED_FEED_VIEW WHERE ID ="+id;
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;


	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          Statement st = con.createStatement();
	          ResultSet rs = st.executeQuery(sql);
	         
	         
	         if(rs.next()){
	        	 
	        	String memId = rs.getNString("mem_id");
	        	String reportedId = rs.getNString("reported_id");
	        	String repoContent = rs.getString("repo_content");
	        	Date repoDate = rs.getDate("repo_date");
	        	int repoCnt = rs.getInt("repo_cnt");
	        	String action = rs.getNString("action");
	        	
	        	fr = new ReportedFeedView(id, memId, reportedId, repoDate, repoContent, repoCnt, action);
	        	
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
	public List<ReportedFeedView> getList() {
		 String sql = "SELECT * FROM REPORTED_FEED_VIEW";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      List<ReportedFeedView> list= new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          Statement st = con.createStatement();
	          ResultSet rs = st.executeQuery(sql);
	         
	         
	         while(rs.next()){
	        	int id = rs.getInt("id");
	        	String memId = rs.getNString("mem_id");
	        	String reportedId = rs.getString("reported_id");
	        	Date repoDate = rs.getDate("repo_date");
	        	String repoContent = rs.getString("repo_content");
	        	int repoCnt=rs.getInt("repo_cnt");
	        	String action = rs.getNString("action");
	        	
	        	ReportedFeedView rf = new ReportedFeedView(id, memId, reportedId, repoDate, repoContent, repoCnt, action);
	        	
	        	list.add(rf);
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
	public List<ReportedFeedView> getList(int page) {
		
		return getList(0);
	}

}
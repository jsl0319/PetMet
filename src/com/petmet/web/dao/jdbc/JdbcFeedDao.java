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

import com.petmet.web.dao.FeedDao;
import com.petmet.web.entity.Feed;
import com.petmet.web.entity.FeedReport;

public class JdbcFeedDao implements FeedDao{

	@Override
	public int insert(Feed feed) {
		  int result = 0;
		
		  String sql = "INSERT INTO FEEDREPORT(CONTENT, WRITER_ID, FILES) VALUES(?,?,?)";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          st.setString(1, feed.getContent());
	          st.setString(2, feed.getWriterId());
	          st.setString(3, feed.getfiles());
	          
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
	public int update(Feed feed) {
		  int result = 0;
			
		  String sql = "UPDATE FEEDREPORT SET CONTENT=?, WRITER_ID=?, FILES=? WHERE ID=?";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;


	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          PreparedStatement st = con.prepareStatement(sql);
	          
	          st.setString(1, feed.getContent());
	          st.setString(2, feed.getWriterId());
	          st.setString(3, feed.getfiles());
	          st.setInt(4, feed.getId());
	          
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
		
		  String sql = "DELETE FROM FEED WHERE ID=?";
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
	public Feed get(int id) {
		  Feed fr = null;
		
 		  String sql = "SELECT * FROM FEED WHERE ID ="+id;
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
	        	 String content = rs.getNString("content");
	        	 Date editDate = rs.getDate("edit_date");
	        	 String writerId = rs.getNString("writer_id");
	        	 String files = rs.getNString("files");
	        	 Date regDate = rs.getDate("reg_date");
	        	
	        	fr = new Feed(id, content, editDate, writerId, regDate, files);
	        	
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
	public List<Feed> getList() {
		
		  String sql = "SELECT * FROM FEED";
		  String url = DBContext.URL;
		  String uid = DBContext.UID;
		  String pwd = DBContext.PWD;

	      List<Feed> list= new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,uid,pwd);
	          Statement st = con.createStatement();
	          ResultSet rs = st.executeQuery(sql);
	         
	         
	         while(rs.next()){
	        	int id = rs.getInt("id");
	        	String content = rs.getNString("content");
	        	Date editDate = rs.getDate("edit_date");
	        	String writerId = rs.getNString("writer_id");
	        	Date regDate = rs.getDate("reg_date");
	        	String files = rs.getNString("files");
	        	
	        	Feed f = new Feed(id, content, editDate, writerId, regDate, files);
	        	
	        	list.add(f);
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
	public List<Feed> getList(int page) {
		
			return getList(0);
	}

	

}

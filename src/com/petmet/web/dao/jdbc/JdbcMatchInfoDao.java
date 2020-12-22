package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petmet.web.dao.MatchInfoDao;
import com.petmet.web.entity.MatchInfoView;

public class JdbcMatchInfoDao implements MatchInfoDao{

	   @Override
	   public List<MatchInfoView> getViewList(int startIndex, int endIndex) {
	      List<MatchInfoView> list = new ArrayList<>();

	      String url = DBContext.URL;
	      String uid = DBContext.UID;
	      String pwd = DBContext.PWD;

	      String sql = "SELECT * FROM MATCH_INFO_VIEW"; 
	            

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, uid, pwd);
	         PreparedStatement st = con.prepareStatement(sql);
	         ResultSet rs = st.executeQuery();

	         while (rs.next()) {
	            int id = rs.getInt("ID");
	            Date regDate = rs.getDate("REG_DATE"); 
	            int pub = rs.getInt("PUB");
	            String matchContent = rs.getString("MATCH_CONTENT");
	            String name = rs.getString("NAME");
	            String kind= rs.getString("KIND");
	            int gender= rs.getInt("GENDER");
	            int neut= rs.getInt("NEUT");
	            Date birth= rs.getDate("BIRTH"); 
	            int weight= rs.getInt("WEIGHT");
	            String dogContent= rs.getString("DOG_CONTENT");
	            String character= rs.getString("CHARACTER");
	            String files= rs.getString("FILES");
	            String masterNickname = rs.getString("MASTER_NICKNAME");
	            int masterGender= rs.getInt("MASTER_GENDER");
	            String address = rs.getString("ADDRESS");

	            MatchInfoView matchInfoView = new MatchInfoView(
	                                 id, 
	                                 regDate, 
	                                 pub, 
	                                 matchContent, 
	                                 name,
	                                 kind,
	                                 gender,
	                                 neut,
	                                 birth,
	                                 weight,
	                                 dogContent,
	                                 character,
	                                 files,
	                                 masterNickname,
	                                 masterGender,
	                                 address
	                                 );
	            list.add(matchInfoView);
	   
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
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<MatchInfoView> getViewList() {
		return null;
	}


}

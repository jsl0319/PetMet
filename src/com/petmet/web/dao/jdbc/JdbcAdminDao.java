package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petmet.web.dao.AdminDao;
import com.petmet.web.entity.Admin;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.MatchInfoView;
import com.petmet.web.entity.ReviewView;

public class JdbcAdminDao implements AdminDao{

	
	@Override
	public Admin get(String aid) {
		Admin admin = null;
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd2 = DBContext.PWD;

		String sql = "SELECT * FROM ADMIN WHERE EMAIL='"+aid+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd2);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				int id = rs.getInt("ID");
				String email = rs.getString("EMAIL");
				String pwd= rs.getString("pwd");
				String nickname= rs.getString("nickname");
				
				
				admin = new Admin(
						id,  email,  pwd,  nickname);
			}

			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(admin.getEmail());
		return admin;
	}

	@Override
	public List<MatchInfoView> getMatchInfo() {
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;
		
		String sql = "SELECT TO_CHAR(REG_DATE, 'MM/DD') REG_DATE, COUNT(*) CNT "
					+ "FROM MATCH_INFO_VIEW "
					+ "GROUP BY TO_CHAR(REG_DATE, 'MM/DD') "
					+ "ORDER BY REG_DATE";

		List<MatchInfoView> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement pst = con.createStatement();
			ResultSet rs = pst.executeQuery(sql);

			while (rs.next()) {
				String regDate = rs.getString("REG_DATE");
				int count = rs.getInt("CNT");

				MatchInfoView m = new MatchInfoView(count, null, 0, null, regDate, null, 0, 0, null, 0, null, null, null, null, 0, null);

				list.add(m);
			}

			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ReviewView> getReview() {
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;
		
		String sql = "SELECT TO_CHAR(REG_DATE, 'MM/DD') REG_DATE, COUNT(*) CNT "
					+ "FROM REVIEW_VIEW "
					+ "GROUP BY TO_CHAR(REG_DATE, 'MM/DD') "
					+ "ORDER BY REG_DATE";

		List<ReviewView> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement pst = con.createStatement();
			ResultSet rs = pst.executeQuery(sql);

			while (rs.next()) {
				String regDate = rs.getString("REG_DATE");
				int count = rs.getInt("CNT");

				ReviewView r = new ReviewView(count, 0, 0, 0, null, null, null, regDate, null, 0);

				list.add(r);
			}

			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}

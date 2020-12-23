package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.petmet.web.dao.AdminDao;
import com.petmet.web.entity.Admin;

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
}

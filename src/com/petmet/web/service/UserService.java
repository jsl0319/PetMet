package com.petmet.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.petmet.web.entity.User;

public class UserService {
	
	public List<User> getList() {
		
		List<User> list = new ArrayList<>();
		String url ="jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql ="SELECT * FROM \"USER\" ";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"petmet","0000");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			


			while(rs.next()) {
				 int id = rs.getInt("ID");
				 String uid = rs.getString("UID");
			     String pwd = rs.getString("PWD");
			     String name = rs.getString("NAME");
			     String birthday = rs.getString("BIRTHDAY");
			     
			     User m = new User();
			     m.setId(id);
			     m.setUid(uid);
			     m.setPwd(pwd);
			     m.setName(name);
			     m.setBirthday(birthday);
			     
			     list.add(m);
			}
			
	
			rs.close();
			st.close();
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

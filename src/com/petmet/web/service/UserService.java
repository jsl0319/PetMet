package com.petmet.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.petmet.web.entity.User;

// Data 조작 위주
public class UserService {
	private String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	private String userId = "petmet";
	private String pw = "0000";

	// ------------------------------------ Select ------------------------------------
	public List<User> getList() {
		/*
		 * DriverManage; // Oracle SQL Driver(or MS SQL Driver) 생성 Connection connect;
		 * // Oracle SQL Driver(or MS SQL Driver)와 JDBC api를 연결 Statement st; // 문장 실행
		 * 도구 생성 like sqlDeveloper의 스크립트/워크시트 ResultSet rs; // 테이블 데이터 전체
		 */

		// Driver Manager 생성 코드 => but, jdk에 밑에 코드를 자동 실행하는 코드가 삽입 되어있음
		// Class.forName("oracle.jdbc.driver.OracleDriver");

		String sql = "SELECT * FROM \"USER\"";

		List<User> list = new ArrayList<User>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, userId, pw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String uid = rs.getString("UID");
				String pwd = rs.getString("PWD");
				String birthday = rs.getString("BIRTHDAY");
				
				User u = new User(id, name, uid, pwd, birthday);
				
				list.add(u);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}

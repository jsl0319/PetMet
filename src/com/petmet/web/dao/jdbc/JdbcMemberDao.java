package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petmet.web.dao.MemberDao;
import com.petmet.web.entity.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public int insert(Member member) {

		return 0;
	}

	@Override
	public Member get(int id) {
		Member member = null;
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT * FROM MEMBER WHERE ID="+id;


		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String email = rs.getString("EMAIL");
				String pw = rs.getString("PWD");
				String nickname = rs.getString("NICKNAME");
				int gender = rs.getInt("GENDER");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				Date regDate = rs.getDate("REG_DATE");

				member = new Member(id, email,pw,nickname,gender,address,phone,regDate);
				
			}

			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		return member;
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Member> getList() {

		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT * FROM MEMBER ORDER BY ID ASC";

		List<Member> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("ID");
				String email = rs.getString("EMAIL");
				String pw = rs.getString("PWD");
				String nickname = rs.getString("NICKNAME");
				int gender = rs.getInt("GENDER");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				Date regDate = rs.getDate("REG_DATE");

				Member member = new Member(id, email,pw,nickname,gender,address,phone,regDate);

				list.add(member);
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

}

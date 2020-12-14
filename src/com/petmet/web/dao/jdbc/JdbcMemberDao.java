package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.petmet.web.entity.Member;
import com.petmet.web.dao.MemberDao;

public class JdbcMemberDao implements MemberDao{

	@Override
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Member member) {
		int result = 0;

		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;
		String sql = "UPDATE MEMBER SET NICKNAME=?,ADDRESS=? WHERE ID=?";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getNickname());
			st.setString(2, member.getAddress());

			result = st.executeUpdate();

			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

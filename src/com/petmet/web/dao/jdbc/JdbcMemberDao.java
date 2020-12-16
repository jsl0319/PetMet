package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petmet.web.dao.MemberDao;
import com.petmet.web.entity.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public List<Member> getList(String field, String query, String startDate, String endDate, int startIndex,
			int endIndex) {
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT * FROM "
						+ "(SELECT ROWNUM NUM,M.* FROM MEMBER M "
						+ "WHERE "+field+" LIKE ? AND "
						+ "REG_DATE>? AND "
						+ "REG_DATE<(SELECT TO_DATE(?,'YY-MM-DD')+1 FROM DUAL))" 
						+ "WHERE NUM BETWEEN ? AND ?";

		List<Member> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setString(2, startDate);
			st.setString(3, endDate);
			st.setInt(4, startIndex);
			st.setInt(5, endIndex);
			ResultSet rs = st.executeQuery();

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

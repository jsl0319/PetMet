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

import com.petmet.web.dao.MemberDao;
import com.petmet.web.entity.Member;
import com.petmet.web.entity.MemberView;

public class JdbcMemberDao implements MemberDao {

	@Override
	public List<Member> getList(String field, String query, String startDate, String endDate, int startIndex,
			int endIndex) {
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT * FROM "
						+ "(SELECT ROWNUM NUM,M.* FROM "
						+ "(SELECT * FROM MEMBER "
						+ "WHERE "+field+" LIKE ? AND "
						+ "REG_DATE>? AND "
						+ "REG_DATE<(SELECT TO_DATE(?,'YY-MM-DD')+1 FROM DUAL)"
						+ " ORDER BY REG_DATE DESC) M ) " 
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

	@Override
	public MemberView get(int id) {
		MemberView memberView = null;
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT * FROM MEMBER_VIEW WHERE ID="+id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String nickname = rs.getString("NICKNAME");
				Date regDate = rs.getDate("REG_DATE");
				int dogNum = rs.getInt("DOG_NUM");
				int mtReqNum = rs.getInt("MT_REQ_NUM");
			
				int mtRespNum = rs.getInt("MT_RESP_NUM");
				
				int mtSuccess = rs.getInt("MT_SUCCESS");
				
				int repNum=rs.getInt("REP_NUM");
				
				memberView = new MemberView(
						id,nickname,regDate,dogNum,mtReqNum,mtRespNum,mtSuccess,repNum);
			}

			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return memberView;
	}

	@Override
	public int getCount(String field, String query, String startDate, String endDate) {
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT COUNT(ID) COUNT FROM "
						+ "(SELECT ROWNUM NUM,M.* FROM "
						+ "(SELECT * FROM MEMBER "
						+ "WHERE "+field+" LIKE ? AND "
						+ "REG_DATE>? AND "
						+ "REG_DATE<(SELECT TO_DATE(?,'YY-MM-DD')+1 FROM DUAL)"
						+ " ORDER BY REG_DATE DESC) M ) ";
						

		int count = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setString(2, startDate);
			st.setString(3, endDate);
			ResultSet rs = st.executeQuery();

			if(rs.next())
				count = rs.getInt("COUNT");
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return count;
	}

	
	
}

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

import com.petmet.web.dao.MatchingDao;
import com.petmet.web.entity.Matching;
import com.petmet.web.entity.MatchingView;
import com.petmet.web.entity.Member;

public class JdbcMatchingDao implements MatchingDao {

	@Override
	public List<MatchingView> getList(int field, String startDate, String endDate, int startIndex, int endIndex) {
		List<MatchingView> list = new ArrayList<>();

		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sqlMiddle = "";
		switch (field) {
		case -1:
			break;

		default:
			sqlMiddle = "AND RESULT=" + field;
			break;
		}
		String sql = "SELECT * FROM " + "(SELECT ROWNUM NUM,M.* FROM " + "(SELECT * FROM MATCHING_VIEW "
				+ "WHERE REQ_DATE>? AND REQ_DATE<(SELECT TO_DATE(?,'YY-MM-DD')+1 FROM DUAL) " + sqlMiddle
				+ " ORDER BY REQ_DATE DESC) M)" + "WHERE NUM BETWEEN ? AND ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, startDate);
			st.setString(2, endDate);
			st.setInt(3, startIndex);
			st.setInt(4, endIndex);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String reqId = rs.getString("REQ_ID");
				String respId = rs.getString("RESP_ID");
				int reqDogId = rs.getInt("REQ_DOG_ID");
				String reqDogName = rs.getString("REQ_DOG_NAME");
				String reqDogFiles = rs.getString("REQ_DOG_FILES");
				int respDogId = rs.getInt("RESP_DOG_ID");
				String respDogName = rs.getString("RESP_DOG_NAME");
				String respDogFiles = rs.getString("RESP_DOG_FILES");
				Date reqDate = rs.getDate("REQ_DATE");
				String result = rs.getString("RESULT");

				String matchContent = rs.getString("MATCH_CONTENT");

				MatchingView matchingView = new MatchingView(id, reqId, respId, reqDogId, reqDogName, reqDogFiles,
						respDogId, respDogName, respDogFiles, reqDate, result, matchContent);

				list.add(matchingView);
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
	public List<Matching> getReportList(String field, String query, int startIndex, int endIndex) {
		List<Matching> list = new ArrayList<>();

		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT * FROM " + "(SELECT ROWNUM NUM,M.* FROM " + "(SELECT * FROM MATCHING " + "WHERE " + field
				+ " LIKE ? " + "ORDER BY REP_DATE DESC) M ) " + "WHERE NUM BETWEEN ? AND ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, startIndex);
			st.setInt(3, endIndex);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String reqId = rs.getString("REQ_ID");
				String respId = rs.getString("RESP_ID");
				int reqDogId = rs.getInt("REQ_DOG_ID");
				int respDogId = rs.getInt("RESP_DOG_ID");
				Date reqDate = rs.getDate("REQ_DATE");
				String result = rs.getString("RESULT");
				Date resultDate = rs.getDate("RESULT_DATE");
				String repId = rs.getString("REP_ID");
				String repContent = rs.getString("REP_CONTENT");
				Date repDate = rs.getDate("REP_DATE");

				Matching matching = new Matching(id, reqId, respId, reqDogId, respDogId, reqDate, result, resultDate,
						repId, repContent, repDate);

				list.add(matching);
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
	public Matching getReport(int id) {
		Matching matching = null;

		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;
		String sql = "SELECT * FROM MATCHING WHERE ID =" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String reqId = rs.getString("REQ_ID");
				String respId = rs.getString("RESP_ID");
				int reqDogId = rs.getInt("REQ_DOG_ID");
				int respDogId = rs.getInt("RESP_DOG_ID");
				Date reqDate = rs.getDate("REQ_DATE");
				String result = rs.getString("RESULT");
				Date resultDate = rs.getDate("RESULT_DATE");
				String repId = rs.getString("REP_ID");
				String repContent = rs.getString("REP_CONTENT");
				Date repDate = rs.getDate("REP_DATE");

				matching = new Matching(id, reqId, respId, reqDogId, respDogId, reqDate, result, resultDate, repId,
						repContent, repDate);
			}

			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return matching;
	}

	@Override
	public MatchingView get(int id) {
		MatchingView matchingView = null;

		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT * FROM MATCHING_VIEW WHERE ID=" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				String reqId = rs.getString("REQ_ID");
				String respId = rs.getString("RESP_ID");
				int reqDogId = rs.getInt("REQ_DOG_ID");
				String reqDogName = rs.getString("REQ_DOG_NAME");
				String reqDogFiles = rs.getString("REQ_DOG_FILES");
				int respDogId = rs.getInt("RESP_DOG_ID");
				String respDogName = rs.getString("RESP_DOG_NAME");
				String respDogFiles = rs.getString("RESP_DOG_FILES");
				Date reqDate = rs.getDate("REQ_DATE");
				String result = rs.getString("RESULT");

				String matchContent = rs.getString("MATCH_CONTENT");

				matchingView = new MatchingView(id, reqId, respId, reqDogId, reqDogName, reqDogFiles, respDogId,
						respDogName, respDogFiles, reqDate, result, matchContent);

			}

			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return matchingView;
	}

//	@Override
//	public int insert(Matching matching) {
//		int result = 0;
//
//		String sql = "INSERT INTO MATCHING(REQ_ID, RESP_ID, RESULT, REP_CONTENT) VALUES(?, ?, ?, ?)";
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, uid, pwd);
//			PreparedStatement pst = con.prepareStatement(sql);
//			
//			pst.setString(1, matching.getReqId());
//			pst.setString(2, matching.getRespId());
//			pst.setString(3, matching.getResult());
//			pst.setString(4, matching.getRepContent());
//
//			result = pst.executeUpdate();
//
//			pst.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	@Override
//	public int update(Matching matching) {
//		int result = 0;
//
//		String sql = "UPDATE MATCHING SET REQ_ID = ?, RESP_ID = ?, RESULT = ?, REP_DATE =? WHERE ID = ?";
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, uid, pwd);
//			PreparedStatement pst = con.prepareStatement(sql);
//			
//			pst.setString(1, matching.getReqId());
//			pst.setString(2, matching.getRespId());
//			pst.setString(3, matching.getResult());
//			pst.setString(4, matching.getRepContent());
//			pst.setInt(5, matching.getId());
//
//			result = pst.executeUpdate();
//
//			pst.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	@Override
//	public int delete(int id) {
//		int result = 0;
//
//		String sql = "DELETE FROM MATCHING WHERE ID=?";
//
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, uid, pwd);
//			PreparedStatement pst = con.prepareStatement(sql);
//			
//			pst.setInt(1, id);
//			result = pst.executeUpdate();
//
//			pst.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//

}

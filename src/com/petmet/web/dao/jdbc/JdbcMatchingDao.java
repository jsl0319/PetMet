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

public class JdbcMatchingDao implements MatchingDao {
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;
	
	@Override
	public int insert(Matching matching) {
		int result = 0;

		String sql = "INSERT INTO MATCHING(REQ_ID, RESP_ID, RESULT, REP_CONTENT) VALUES(?, ?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, matching.getReqId());
			pst.setString(2, matching.getRespId());
			pst.setString(3, matching.getResult());
			pst.setString(4, matching.getRepContent());

			result = pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(Matching matching) {
		int result = 0;

		String sql = "UPDATE MATCHING SET REQ_ID = ?, RESP_ID = ?, RESULT = ?, REP_DATE =? WHERE ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, matching.getReqId());
			pst.setString(2, matching.getRespId());
			pst.setString(3, matching.getResult());
			pst.setString(4, matching.getRepContent());
			pst.setInt(5, matching.getId());

			result = pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;

		String sql = "DELETE FROM MATCHING WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, id);
			result = pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Matching get(int id) {
		Matching m = null;

		String sql = "SELECT * FROM MATCHING WHERE ID =" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				String reqId = rs.getString("REQ_ID");
				String respId = rs.getString("RESP_ID");
				Date reqDate = rs.getDate("REQ_DATE");
			    String result = rs.getString("RESULT");
			    Date resultDate = rs.getDate("RESULT_DATE");
			    String repContent = rs.getString("REP_CONTENT");
			    Date repDate = rs.getDate("REP_DATE");

			    m = new Matching(id, reqId, respId, reqDate, result, resultDate, repContent, repDate);
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

		return m;
	}

	@Override
	public List<Matching> getList() {
		String sql = "SELECT * FROM MATCHING";

		List<Matching> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("ID");
				String reqId = rs.getString("REQ_ID");
				String respId = rs.getString("RESP_ID");
				Date reqDate = rs.getDate("REQ_DATE");
			    String result = rs.getString("RESULT");
			    Date resultDate = rs.getDate("RESULT_DATE");
			    String repContent = rs.getString("REP_CONTENT");
			    Date repDate = rs.getDate("REP_DATE");

				Matching m = new Matching(id, reqId, respId, reqDate, result, resultDate, repContent, repDate);

				list.add(m);
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

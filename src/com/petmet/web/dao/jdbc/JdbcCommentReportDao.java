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

import com.petmet.web.dao.CommentReportDao;
import com.petmet.web.entity.BoardReport;
import com.petmet.web.entity.CommentReport;

public class JdbcCommentReportDao implements CommentReportDao{
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;
	
	@Override
	public int insert(CommentReport commentReport) {
		int result = 0;

		String sql = "INSERT INTO COMMENT_REPORT(MEM_ID, COMMENT_ID, CONTENT) VALUES(?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, commentReport.getMemId());
			pst.setInt(2, commentReport.getCommentId());
			pst.setString(3, commentReport.getContent());

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
	public int update(CommentReport commentReport) {
		int result = 0;
		String sql = "UPDATE COMMENT_REPORT SET MEM_ID = ?, COMMENT_ID = ?, CONTENT = ? WHERE ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, commentReport.getMemId());
			pst.setInt(2, commentReport.getCommentId());
			pst.setString(3, commentReport.getContent());
			pst.setInt(4, commentReport.getId());

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

		String sql = "DELETE FROM COMMENT_REPORT WHERE ID=?";

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
	public CommentReport get(int id) {
		CommentReport c = null;

		String sql = "SELECT * FROM COMMENT_REPORT WHERE ID =" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				String memId = rs.getString("MEM_ID");
				int commentId = rs.getInt("COMMENT_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");
				
			    c = new CommentReport(id, memId, commentId, regDate, content);
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

		return c;
	}

	@Override
	public List<CommentReport> getList() {
		String sql = "SELECT * FROM COMMENT_REPORT";

		List<CommentReport> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("ID");
				String memId = rs.getString("MEM_ID");
				int commentId = rs.getInt("COMMENT_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");

				CommentReport c = new CommentReport(id, memId, commentId, regDate, content);

				list.add(c);
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
	public List<CommentReport> getList(int boardId) {
		// TODO Auto-generated method stub
		return null;
	}

}

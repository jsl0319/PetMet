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
import com.petmet.web.entity.CommentReportView;
import com.petmet.web.entity.CommentView;
import com.petmet.web.entity.Comments;

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

		String sql = "SELECT * FROM COMMENT_REPORT WHERE ID =?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				String memId = rs.getString("MEM_ID");
				int commentId = rs.getInt("COMMENT_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");
				
			    c = new CommentReport(id, memId, commentId, regDate, content);
			}

			pst.close();
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
	public List<CommentReport> getList(String selectBox, String query, String boardCategory, Date startDate, Date endDate, int startIndex, int endIndex) {
		String sql = "SELECT * "
					+ "FROM("
					+ "    SELECT ROWNUM NUM, C.* "
					+ "    FROM("
					+ "        SELECT * FROM COMMENT_REPORT ORDER BY REG_DATE DESC"
					+ "    ) C"
					+ ") "
					+ "WHERE NUM BETWEEN ? AND ?";
	
		// 검색폼의 검색 경우의 수
		if (query != null)
			sql += " AND " + selectBox + " LIKE '%" + query + "%'";
	
		if (boardCategory != null)
			sql += " AND CATEGORY_ID LIKE '%" + boardCategory + "%'";
	
		if (startDate != null || endDate != null)
			sql += " AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'";

		List<CommentReport> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			
			ResultSet rs = pst.executeQuery();

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
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<CommentReportView> getViewList(String selectBox, String query, String boardCategory, Date startDate, Date endDate, int startIndex, int endIndex) {
		String sql = "SELECT * FROM REPORTED_COMMENT_VIEW WHERE NUM BETWEEN ? AND ?";

		// 검색폼의 검색 경우의 수
		if (query != null)
			sql += " AND " + selectBox + " LIKE '%" + query + "%'";

		if (boardCategory != null)
			sql += " AND CATEGORY_ID LIKE '%" + boardCategory + "%'";

		if (startDate != null || endDate != null)
			sql += " AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'";
		
		List<CommentReportView> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("NUM");
			    int id = rs.getInt("ID");
			    String categoryId = rs.getString("CATEGORY_ID");
			    int boardId = rs.getInt("BOARD_ID");
			    String title = rs.getString("TITLE");
			    String writerId = rs.getString("WRITER_ID");
			    String content = rs.getString("CONTENT");
			    Date regDate = rs.getDate("REG_DATE");
			    int reported = rs.getInt("REPORTED");
			    
				CommentReportView cv = new CommentReportView(num, id, categoryId, boardId, title, writerId, content, regDate, reported);

				list.add(cv);
			}

			rs.close();
			pst.close();
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

	@Override
	public List<CommentReport> getListByCommentId(int commentId) {
		String sql = "SELECT * "
					+ "FROM("
					+ "    SELECT ROWNUM NUM, CR.* "
					+ "    FROM("
					+ "        SELECT * FROM COMMENT_REPORT ORDER BY REG_DATE DESC"
					+ "    ) CR "
					+ ") "
					+ "WHERE COMMENT_ID = ?";

		List<CommentReport> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, commentId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String memId = rs.getString("MEM_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");

				CommentReport cr = new CommentReport(id, memId, commentId, regDate, content);

				list.add(cr);
			}

			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

}

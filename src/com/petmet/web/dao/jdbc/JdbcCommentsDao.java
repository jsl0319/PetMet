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

import com.petmet.web.dao.CommentsDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardView;
import com.petmet.web.entity.CommentView;
import com.petmet.web.entity.Comments;

public class JdbcCommentsDao implements CommentsDao{
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(Comments comment) {
		int result = 0;

		String sql = "INSERT INTO COMMENTS(WRITER_ID, BOARD_ID, CONTENT) VALUES(?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, comment.getWriterId());
			pst.setInt(2, comment.getBoardId());
			pst.setString(3, comment.getContent());

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
	public int update(Comments comment) {
		int result = 0;
		String sql = "UPDATE COMMENTS SET WRITER_ID = ?, BOARD_ID = ?, CONTENT = ? WHERE ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, comment.getWriterId());
			pst.setInt(2, comment.getBoardId());
			pst.setString(3, comment.getContent());
			pst.setInt(4, comment.getId());

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

		String sql = "DELETE FROM COMMENTS WHERE ID=?";

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
	public Comments get(int id) {
		Comments c = null;

		String sql = "SELECT * FROM COMMENTS WHERE ID =?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareCall(sql);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				String writerId = rs.getString("WRITER_ID");
				int boardId = rs.getInt("BOARD_ID");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REG_DATE");

			    c = new Comments(id, writerId, boardId, content, regDate);
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
	public List<Comments> getList(String selectBox, String query, String boardCategory, String startDate, String endDate,
			int startIndex, int endIndex) {
		String sql = "SELECT * "
					+ "FROM("
					+ "    SELECT ROWNUM NUM, C.* "
					+ "    FROM("
					+ "        SELECT * FROM COMMENTS ORDER BY REG_DATE DESC"
					+ "    ) C "
					+ "		WHERE " + selectBox + " LIKE '%" + query + "%'"
					+ " 	AND CATEGORY_ID LIKE '%" + boardCategory + "%'"
					+ " 	AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'"
					+ ") "
					+ "WHERE NUM BETWEEN ? AND ?";

		List<Comments> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				int boardId = rs.getInt("BOARD_ID");
				String writerId = rs.getString("WRITER_ID");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REG_DATE");

				Comments c = new Comments(id, writerId, boardId, content, regDate);

				list.add(c);
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
	public CommentView getView(String subQuery) {
		String sql = "SELECT * FROM COMMENT_VIEW ";
		sql += subQuery;
		
		CommentView cv = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				int num = rs.getInt("NUM");
				int id = rs.getInt("ID");
				int categoryId = rs.getInt("CATEGORY_ID");
				String categoryName = rs.getString("CATEGORY_NAME");
				int boardId = rs.getInt("BOARD_ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");

				cv = new CommentView(num, id, categoryId, categoryName, boardId, title, writerId, content, regDate);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return cv;
	}

	@Override
	public List<CommentView> getViewList(String field, String query, String board, String startDate, String endDate) {
		String sql = "SELECT * FROM(" +
						"SELECT ROWNUM NUM2, CV.* FROM COMMENT_VIEW CV " +
						"WHERE " + field + " LIKE '%" + query + "%' " +
						"AND CATEGORY_NAME LIKE '%" + board + "%' " +
						"AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'" + ") ";

		List<CommentView> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int num = rs.getInt("NUM");
				int id = rs.getInt("ID");
				int categoryId = rs.getInt("CATEGORY_ID");
				String categoryName = rs.getString("CATEGORY_NAME");
				int boardId = rs.getInt("BOARD_ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");

				CommentView cv = new CommentView(num, id, categoryId, categoryName, boardId, title, writerId, content,
						regDate);

				list.add(cv);
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

	@Override
	public List<CommentView> getViewList(String selectBox, String query, String boardCategory, String startDate,
			String endDate, int startIndex, int endIndex) {

		String sql = "SELECT * FROM("
						+ "SELECT ROWNUM NUM2, CV.* FROM COMMENT_VIEW CV "
						+ "WHERE " + selectBox + " LIKE '%" + query + "%' "
						+ "AND CATEGORY_NAME LIKE '%" + boardCategory + "%' "
						+ "AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'"
						+ ") "
					+ "WHERE NUM2 BETWEEN ? AND ?";

		List<CommentView> list = new ArrayList<>();

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
				int categoryId = rs.getInt("CATEGORY_ID");
				String categoryName = rs.getString("CATEGORY_NAME");
				int boardId = rs.getInt("BOARD_ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");

				CommentView cv = new CommentView(num, id, categoryId, categoryName, boardId, title, writerId, content, regDate);

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

}

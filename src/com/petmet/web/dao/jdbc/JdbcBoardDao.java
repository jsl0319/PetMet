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

import com.petmet.web.dao.BoardDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardView;
import com.petmet.web.entity.Notice;

public class JdbcBoardDao implements BoardDao {
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(Board board) {
		int result = 0;

		String sql = "INSERT INTO BOARD(TITLE, CONTENT, WRITER_ID, FILES, CATEGORY_ID) VALUES(?, ?, ?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getWriterId());
			pst.setString(4, board.getFiles());
			pst.setInt(5, board.getCategoryId());

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
	public int update(Board board) {
		int result = 0;
		String sql = "UPDATE BOARD SET TITLE=?, CONTENT=?, WRITER_ID=?, FILES=?, CATEGORY_ID=?, HIT=? WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getWriterId());
			pst.setString(4, board.getFiles());
			pst.setInt(5, board.getCategoryId());
			pst.setInt(6, board.getHit());
			pst.setInt(7, board.getId());

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

		String sql = "DELETE FROM BOARD WHERE ID=?";

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
	public Board get(int id) {
		Board b = null;

		String sql = "SELECT * FROM BOARD WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REG_DATE");
				String files = rs.getString("FILES");
				int categoryId = rs.getInt("CATEGORY_ID");

				b = new Board(id, title, content, hit, writerId, regDate, files, categoryId);
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

		return b;
	}

	@Override
	public List<Board> getList(String selectBox, String query, String boardCategory, String startDate, String endDate,
			int startIndex, int endIndex) {

		String sql = "SELECT * "
						+ "FROM("
						+ "    SELECT ROWNUM NUM, B.* "
						+ "    FROM("
						+ "        SELECT * FROM BOARD ORDER BY REG_DATE DESC"
						+ "    ) B"
						+ "		WHERE " + selectBox + " LIKE '%" + query + "%'"
						+ " 	AND CATEGORY_ID LIKE '%" + boardCategory + "%'"
						+ " 	AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'"
						+ ") "
						+ "WHERE NUM BETWEEN ? AND ?";

		List<Board> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REG_DATE");
				String files = rs.getString("FILES");
				int categoryId = rs.getInt("CATEGORY_ID");

				Board b = new Board(id, title, content, hit, writerId, regDate, files, categoryId);

				list.add(b);
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
	public BoardView getView(int id) {
		String sql = "SELECT * FROM BOARD_VIEW WHERE ID = ?";
		BoardView bv = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				int num = rs.getInt("NUM");
				String title = rs.getString("TITLE");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REG_DATE");
				String files = rs.getString("FILES");
				int categoryId = rs.getInt("CATEGORY_ID");
				String categoryName = rs.getString("CATEGORY_NAME");
				int cmtCnt = rs.getInt("CMT_CNT");

				bv = new BoardView(num, id, title, hit, writerId, regDate, files, categoryId, categoryName, cmtCnt);
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

		return bv;
	}

	@Override
	public List<BoardView> getViewList(String selectBox, String query, String boardCategory, String startDate,
			String endDate) {

		String sql = "SELECT * FROM("
						+ "SELECT ROWNUM NUM2, BV.* FROM BOARD_VIEW BV "
						+ "WHERE " + selectBox + " LIKE '%" + query + "%' "
						+ "AND CATEGORY_NAME LIKE '%" + boardCategory + "%' "
						+ "AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'"
						+ ") ";
		
		List<BoardView> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int num = rs.getInt("NUM");
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REG_DATE");
				String files = rs.getString("FILES");
				int categoryId = rs.getInt("CATEGORY_ID");
			    String categoryName = rs.getString("CATEGORY_NAME");
				int cmtCnt = rs.getInt("CMT_CNT");

				BoardView b = new BoardView(num, id, title, hit, writerId, regDate, files, categoryId, categoryName, cmtCnt);

				list.add(b);
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
	public List<BoardView> getViewList(String selectBox, String query, String boardCategory, String startDate,
			String endDate, int startIndex, int endIndex) {

		String sql = "SELECT * FROM("
						+ "SELECT ROWNUM NUM2, BV.* FROM BOARD_VIEW BV "
						+ "WHERE " + selectBox + " LIKE '%" + query + "%' "
						+ "AND CATEGORY_NAME LIKE '%" + boardCategory + "%' "
						+ "AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'"
						+ ") "
						+ "WHERE NUM2 BETWEEN ? AND ?";
		
		List<BoardView> list = new ArrayList<>();

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
				String title = rs.getString("TITLE");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REG_DATE");
				String files = rs.getString("FILES");
				int categoryId = rs.getInt("CATEGORY_ID");
			    String categoryName = rs.getString("CATEGORY_NAME");
				int cmtCnt = rs.getInt("CMT_CNT");

				BoardView b = new BoardView(num, id, title, hit, writerId, regDate, files, categoryId, categoryName, cmtCnt);

				list.add(b);
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

package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.Comments;
import com.petmet.web.entity.Matching;

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
			pst.setString(5, board.getCategoryId());

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
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WRITER_ID = ?, FILES = ?, CATEGORY_ID =? WHERE ID = ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, board.getTitle());
			pst.setString(2, board.getContent());
			pst.setString(3, board.getWriterId());
			pst.setString(4, board.getFiles());
			pst.setString(5, board.getCategoryId());
			pst.setInt(6, board.getId());

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

		String sql = "SELECT * FROM BOARD WHERE ID =" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("HIT");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REG_DATE");
				String files = rs.getString("FILES");
				String categoryId = rs.getString("CATEGORY_ID");

			    b = new Board(id, title, content, hit, writerId, regDate, files, categoryId);
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

		return b;
	}

	@Override
	public List<Board> getList() {
		return getList(0, null, 0, null, null, 0);
	}

	@Override
	public List<Board> getList(int page) {

		return getList(0, null, 0, null, null, page);
	}
	
	@Override
	public List<Board> getList(int category, String searchContent, int page) {
		return getList(category, searchContent, 0, null, null, page);
	}

	@Override
	public List<Board> getList(int boardCategory, int page) {

		return getList(0, null, boardCategory, null, null, page);
	}

	@Override
	public List<Board> getList(Date startDate, Date endDate, int page) {

		return getList(0, null, 0, startDate, endDate, page);
	}

	@Override
	public List<Board> getList(int category, String searchContent, int boardCategory, int page) {

		return getList(category, searchContent, boardCategory, null, null, page);
	}

	@Override
	public List<Board> getList(int category, String searchContent, Date startDate, Date endDate, int page) {

		return getList(category, searchContent, 0, startDate, endDate, page);
	}

	@Override
	public List<Board> getList(int boardCategory, Date startDate, Date endDate, int page) {

		return getList(0, null, boardCategory, startDate, endDate, page);
	}

	@Override
	public List<Board> getList(int category, String searchContent, int boardCategory, Date startDate, Date endDate,
			int page) {

		return getList(category, searchContent, boardCategory, startDate, endDate, page);
	}

	@Override
	public int deleteList(List<Integer> ids) {

		return 0;
	}

	@Override
	public Board getPrev(int id) {

		return null;
	}

	@Override
	public Board getNext(int id) {

		return null;
	}

	@Override
	public int updateList(List<Board> board) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import com.petmet.web.dao.CommentsDao;
import com.petmet.web.entity.Board;
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

		String sql = "SELECT * FROM COMMENTS WHERE ID =" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				String writerId = rs.getString("WRITER_ID");
				int boardId = rs.getInt("BOARD_ID");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REG_DATE");

			    c = new Comments(id, writerId, boardId, content, regDate);
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
	public List<Comments> getList() {

		return getList(0, null, 0, null, null, 0);
	}

	@Override
	public List<Comments> getList(int page) {

		return getList(0, null, 0, null, null, page);
	}

	@Override
	public List<Comments> getList(int category, String searchContent, int page) {

		return getList(category, searchContent, 0, null, null, page);
	}

	@Override
	public List<Comments> getList(int boardCategory, int page) {

		return getList(0, null, boardCategory, null, null, page);
	}

	@Override
	public List<Comments> getList(Date startDate, Date endDate, int page) {

		return getList(0, null, 0, startDate, endDate, page);
	}

	@Override
	public List<Comments> getList(int category, String searchContent, int boardCategory, int page) {

		return getList(category, searchContent, boardCategory, null, null, page);
	}

	@Override
	public List<Comments> getList(int category, String searchContent, Date startDate, Date endDate, int page) {

		return getList(category, searchContent, 0, startDate, endDate, page);
	}

	@Override
	public List<Comments> getList(int boardCategory, Date startDate, Date endDate, int page) {

		return getList(0, null, boardCategory, startDate, endDate, page);
	}

	@Override
	public List<Comments> getList(int category, String searchContent, int boardCategory, Date startDate, Date endDate,
			int page) {

		return getList(category, searchContent, boardCategory, startDate, endDate, page);
	}

	@Override
	public int deleteList(List<Integer> ids) {

		return 0;
	}

	@Override
	public Comments getPrev(int id) {

		return null;
	}

	@Override
	public Comments getNext(int id) {

		return null;
	}
	
}

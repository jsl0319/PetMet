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

import com.petmet.web.dao.BoardCategoryDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardCategoryView;
import com.petmet.web.entity.Matching;

public class JdbcBoardCategoryDao implements BoardCategoryDao{
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(BoardCategory boardCategory) {
		int result = 0;

		String sql = "INSERT INTO BOARD_CATEGORY(NAME) VALUES(?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, boardCategory.getName());

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
	public int update(BoardCategory boardCategory) {
		int result = 0;
		String sql = "UPDATE BOARD_CATEGORY SET NAME=? WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, boardCategory.getName());
			pst.setInt(2, boardCategory.getId());

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

		String sql = "DELETE FROM BOARD_CATEGORY WHERE ID=?";

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
	public BoardCategory get(int id) {
		BoardCategory b = null;

		String sql = "SELECT * FROM BOARD_CATEGORY WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("NAME");

			    b = new BoardCategory(id, name);
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
	public List<BoardCategory> getList() {
		return getList(1, 20);
	}
	
	@Override
	public List<BoardCategory> getList(int startIndex, int endIndex) {
		String sql = "SELECT * " + 
					"FROM(" + 
					"    SELECT ROWNUM NUM, BC.* " + 
					"    FROM(" + 
					"        SELECT * FROM BOARD_CATEGORY ORDER BY ID" + 
					"    ) BC" + 
					"    ) " + 
					"WHERE NUM BETWEEN ? AND ?";

		List<BoardCategory> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");

				BoardCategory b = new BoardCategory(id, name);

				list.add(b);
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
	public List<BoardCategoryView> getViewList(int startIndex, int endIndex) {
		String sql = "SELECT * FROM BOARD_CATEGORY_VIEW WHERE NUM BETWEEN ? AND ?";

		List<BoardCategoryView> list = new ArrayList<>();

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
				String name = rs.getString("NAME");
				int cntBoard = rs.getInt("CNT_BOARD");
				
				BoardCategoryView bcv = new BoardCategoryView(num, id, name, cntBoard);

				list.add(bcv);
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

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

import com.petmet.web.dao.PetPlaceCategoryDao;
import com.petmet.web.entity.PetPlaceCategory;
import com.petmet.web.entity.PetPlaceCategoryView;

public class JdbcPetPlaceCategoryDao implements PetPlaceCategoryDao {

	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(PetPlaceCategory ppc) {

		int result = 0;

		String sql = "INSERT INTO PETPLACE_CATEGORY(NAME) VALUES(?)";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, ppc.getName());

			result = st.executeUpdate();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(PetPlaceCategory ppc) {
		int result = 0;

		String sql = "UPDATE PETPLACE_CATEGORY SET NAME=?,EDIT_DATE = SYSTIMESTAMP WHERE ID=?";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, ppc.getName());
			st.setInt(2, ppc.getId());
			result = st.executeUpdate();
			st.close();
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

		String sql = "DELETE FROM PETPLACE_CATEGORY WHERE ID=?";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			result = st.executeUpdate();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public PetPlaceCategory get(int id) {
		PetPlaceCategory ppc = null;

		String sql = "SELECT * FROM PETPLACE_CATEGORY WHERE ID=" + id;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("NAME");

				ppc = new PetPlaceCategory(id, name);
			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ppc;
	}

	@Override
	public List<PetPlaceCategory> getList() {
		String sql = "SELECT * FROM PETPLACE_CATEGORY_VIEW";

		List<PetPlaceCategory> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				Date regDate = rs.getDate("REG_DATE");
				Date editDate = rs.getDate("EDIT_DATE");

				PetPlaceCategory ppc = new PetPlaceCategory(id, name, regDate, editDate);

				list.add(ppc);
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
	public List<PetPlaceCategoryView> getViewList() {

		String sql = "SELECT * FROM PETPLACE_CATEGORY_VIEW";

		List<PetPlaceCategoryView> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				Date regDate = rs.getDate("REG_DATE");
				Date editDate = rs.getDate("EDIT_DATE");
				int num = rs.getInt("NUM");

				PetPlaceCategoryView ppcView = new PetPlaceCategoryView(id, name, regDate, editDate, num);

				list.add(ppcView);
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
	public int getLastIndex() {

		PetPlaceCategoryView ppc = null;
		String sql = "SELECT * FROM PETPLACE_CATEGORY_VIEW WHERE ID = (SELECT MAX(ID) FROM PETPLACE_CATEGORY_VIEW)";
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				Date regDate = rs.getDate("REG_DATE");
				Date editDate = rs.getDate("EDIT_DATE");
				int num = rs.getInt("NUM");

				ppc = new PetPlaceCategoryView(id, name, regDate, editDate, num);

			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ppc.getNum();
		
	}

	@Override
	public List<PetPlaceCategoryView> getViewList(String query, int startIndex, int endIndex) {
		
		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM NUM2, PV.* FROM"
				+ "(SELECT * FROM"
				+ "    (SELECT * FROM PETPLACE_CATEGORY_VIEW"
				+ "        WHERE NAME LIKE ? )) PV )"
				+ "        WHERE NUM2 BETWEEN ? AND ?";
		
		
		List<PetPlaceCategoryView> list = new ArrayList<>();
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, startIndex);
			st.setInt(3, endIndex);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				Date regDate = rs.getDate("REG_DATE");
				Date editDate = rs.getDate("EDIT_DATE");
				int num = rs.getInt("NUM");

				PetPlaceCategoryView ppc = new PetPlaceCategoryView(id, name, regDate, editDate, num);
				
				list.add(ppc);
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
	public List<PetPlaceCategoryView> getViewList(String query) {
		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM NUM2, PV.* FROM"
				+ "(SELECT * FROM"
				+ "    (SELECT * FROM PETPLACE_CATEGORY_VIEW"
				+ "        WHERE NAME LIKE ? )) PV )";
		
		
		List<PetPlaceCategoryView> list = new ArrayList<>();
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				Date regDate = rs.getDate("REG_DATE");
				Date editDate = rs.getDate("EDIT_DATE");
				int num = rs.getInt("NUM");

				PetPlaceCategoryView ppc = new PetPlaceCategoryView(id, name, regDate, editDate, num);
				
				list.add(ppc);
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

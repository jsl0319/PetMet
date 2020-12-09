package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.petmet.web.dao.PetPlaceCategoryDao;
import com.petmet.web.entity.PetPlaceCategory;

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

		String sql = "UPDATE PETPLACE_CATEGORY SET NAME=? WHERE ID=?";

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

				ppc = new PetPlaceCategory();
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
		String sql = "SELECT * FROM PETPLACE_CATEGORY";

		List<PetPlaceCategory> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");

				PetPlaceCategory ppc = new PetPlaceCategory(id, name);

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

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

import com.petmet.web.dao.PetPlaceDao;
import com.petmet.web.entity.PetPlace;

public class JdbcPetPlaceDao implements PetPlaceDao {
	
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(PetPlace pp) {
		int result = 0;
		String sql = "INSERT INTO PETPLACE(NAME, CONTENT) VALUES(?,?)";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pp.getName());
			st.setString(2, pp.getContent());

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
	public int update(PetPlace pp) {
		int result = 0;

		String sql = "UPDATE PETPLACE SET NAME=?, CONTENT=? WHERE ID=?";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pp.getName());
			st.setString(2, pp.getContent());
			st.setInt(3, pp.getId());

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

		String sql = "DELETE FROM PETPLACE WHERE ID=?";

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
	public PetPlace get(int id) {
		PetPlace pp = null;

		String sql = "SELECT * FROM PETPLACE WHERE ID=" + id;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				String writerId = rs.getString("WRITER_ID");
				String categoryId = rs.getString("CATEGORY_ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				String homepage = rs.getString("HOMEPAGE");
				String phone = rs.getString("PHONE");
				String location = rs.getString("LOCATION");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REG_DATE");
				String files = rs.getString("FILES");
				int hit = rs.getInt("HIT");
				int likes = rs.getInt("LIKES");
				int pub = rs.getInt("PUB");

				pp = new PetPlace(id, writerId, categoryId, name, address, homepage, phone, location, content, regDate,
						files, hit, likes, pub);
			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return pp;
	}

	@Override
	public List<PetPlace> getList() {
		String sql = "SELECT * FROM PETPLACE";

		List<PetPlace> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("ID");
				String writerId = rs.getString("WRITER_ID");
				String categoryId = rs.getString("CATEGORY_ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				String homepage = rs.getString("HOMEPAGE");
				String phone = rs.getString("PHONE");
				String location = rs.getString("LOCATION");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REG_DATE");
				String files = rs.getString("FILES");
				int hit = rs.getInt("HIT");
				int likes = rs.getInt("LIKES");
				int pub = rs.getInt("PUB");

				PetPlace pp = new PetPlace(id, writerId, categoryId, name, address, homepage, phone, location, content,
						regDate, files, hit, likes, pub);

				list.add(pp);
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

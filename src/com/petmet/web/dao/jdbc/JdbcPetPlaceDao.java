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
import com.petmet.web.entity.PetPlaceView;

public class JdbcPetPlaceDao implements PetPlaceDao {

	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(PetPlace pp) {
		int result = 0;
		String sql = "INSERT INTO PETPLACE(WRITER_ID, CATEGORY_ID, NAME, "
				+ "ADDRESS, HOMEPAGE, PHONE, LOCATION, CONTENT, FILES, PUB) " + "VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pp.getWriterId());
			st.setInt(2, pp.getCategoryId());
			st.setString(3, pp.getName());
			st.setString(4, pp.getAddress());
			st.setString(5, pp.getHomepage());
			st.setString(6, pp.getPhone());
			st.setString(7, pp.getLocation());
			st.setString(8, pp.getContent());
			st.setString(9, pp.getFiles());
			st.setInt(10, pp.getPub());

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

		String sql = "UPDATE PETPLACE SET CATEGORY_ID = ?, NAME = ?," + "ADDRESS = ?, HOMEPAGE = ?, PHONE = ?,"
				+ "LOCATION = ?, CONTENT = ?, FILES = ?, PUB = ?" + "WHERE ID = ?";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pp.getCategoryId());
			st.setString(2, pp.getName());
			st.setString(3, pp.getAddress());
			st.setString(4, pp.getHomepage());
			st.setString(5, pp.getPhone());
			st.setString(6, pp.getLocation());
			st.setString(7, pp.getContent());
			st.setString(8, pp.getFiles());
			st.setInt(9, pp.getPub());
			st.setInt(10, pp.getId());

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

				int writerId = rs.getInt("WRITER_ID");
				int categoryId = rs.getInt("CATEGORY_ID");
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
		String sql = "SELECT * FROM (\r\n" + "    SELECT ROWNUM NUM, P.* \r\n"
				+ "    FROM(SELECT * FROM PETPLACE ORDER BY REG_DATE ASC)P)\r\n" + "    ORDER BY NUM DESC;";

		List<PetPlace> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("ID");
				int writerId = rs.getInt("WRITER_ID");
				int categoryId = rs.getInt("CATEGORY_ID");
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

	// ==========================view===========================

	@Override
	public PetPlace getLast() {
		PetPlace pp = null;

		String sql = "SELECT * FROM PETPLACE WHERE ID = (SELECT MAX(ID) FROM NOTICE)";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				int id = rs.getInt("ID");
				int writerId = rs.getInt("WRITER_ID");
				int categoryId = rs.getInt("CATEGORY_ID");
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
	public PetPlaceView getView(int id) {
		PetPlaceView pp = null;

		String sql = "SELECT * FROM PETPLACE_VIEW WHERE ID=" + id;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				int writerId = rs.getInt("WRITER_ID");
				int categoryId = rs.getInt("CATEGORY_ID");
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
				int num = rs.getInt("NUM");
				int reviewCount = rs.getInt("REVIEW_COUNT");
				double avgRating = rs.getDouble("AVG_RATING");
				String writerName = rs.getString("WRITER_NAME");
				String categoryName = rs.getString("CATEGORY_NAME");

				pp = new PetPlaceView(id, writerId, categoryId, name, address, homepage, phone, location, content,
						regDate, files, hit, likes, pub, num, reviewCount, avgRating, writerName, categoryName);
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
	public List<PetPlaceView> getViewList() {
		String sql = "SELECT * FROM PETPLACE_VIEW";

		List<PetPlaceView> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("ID");
				int writerId = rs.getInt("WRITER_ID");
				int categoryId = rs.getInt("CATEGORY_ID");
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
				int num = rs.getInt("NUM");
				int reviewCount = rs.getInt("REVIEW_COUNT");
				double avgRating = rs.getDouble("AVG_RATING");
				String writerName = rs.getString("WRITER_NAME");
				String categoryName = rs.getString("CATEGORY_NAME");
				
				PetPlaceView pp = new PetPlaceView(id, writerId, categoryId, name, address, homepage, phone, location,
						content, regDate, files, hit, likes, pub, num, reviewCount, avgRating, writerName, categoryName);

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

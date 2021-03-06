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
		String sql = "SELECT * FROM (" + "SELECT ROWNUM NUM, P.*"
				+ "FROM(SELECT * FROM PETPLACE ORDER BY REG_DATE ASC)P)" + "ORDER BY NUM DESC;";

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
	public PetPlaceView getLast() {
		PetPlaceView pp = null;

		String sql = "SELECT * FROM PETPLACE_VIEW WHERE ID = (SELECT MAX(ID) FROM PETPLACE_VIEW)";

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
				int reviewCount = rs.getInt("REVIEW_COUNT");
				double avgRating = rs.getDouble("AVG_RATING");
				String writerName = rs.getString("WRITER_NAME");
				String categoryName = rs.getString("CATEGORY_NAME");

				pp = new PetPlaceView(id, writerId, categoryId, name, address, homepage, phone, location, content,
						regDate, files, hit, likes, pub, reviewCount, avgRating, writerName, categoryName);
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
						content, regDate, files, hit, likes, pub, num, reviewCount, avgRating, writerName,
						categoryName);

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

	@Override
	public List<PetPlaceView> getViewList(String field, String query, String startDate, String endDate, int startIndex,
			int endIndex) {

		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM NUM2, P.* FROM"
				+ "(SELECT * FROM PETPLACE_VIEW"
				+ "    WHERE " + field + " LIKE ? AND REG_DATE > ? AND"
				+ "    REG_DATE < (SELECT TO_DATE(?, 'YY-MM-DD')+1 FROM DUAL)) P)"
				+ "    WHERE NUM2 BETWEEN ? AND ?";

		List<PetPlaceView> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setString(2, startDate);
			st.setString(3, endDate);
			st.setInt(4, startIndex);
			st.setInt(5, endIndex);
			ResultSet rs = st.executeQuery();

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
						content, regDate, files, hit, likes, pub, num, reviewCount, avgRating, writerName,
						categoryName);

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
	
	
	// review 전용
	@Override
	public List<PetPlaceView> getViewList(String field, String query, int startIndex, int endIndex) {
		String sql = " SELECT * FROM"
				+ "(SELECT ROWNUM NUM2, P.* FROM"
				+ "(SELECT * FROM PETPLACE_VIEW"
				+ "    WHERE " + field + " LIKE ? ) P )"
				+ "    WHERE NUM2 BETWEEN ? AND ?";

		List<PetPlaceView> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, startIndex);
			st.setInt(3, endIndex);
			ResultSet rs = st.executeQuery();

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
						content, regDate, files, hit, likes, pub, num, reviewCount, avgRating, writerName,
						categoryName);

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

	@Override
	public int getLastIndex() {

		PetPlaceView pp = null;

		String sql = "SELECT * FROM PETPLACE_VIEW WHERE ID = (SELECT MAX(ID) FROM PETPLACE_VIEW)";

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

		return pp.getNum();
	}

	@Override
	public List<PetPlaceView> getViewList(String field, String query, String startDate, String endDate) {
		
		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM NUM2, P.* FROM"
				+ "(SELECT * FROM PETPLACE_VIEW"
				+ "    WHERE " + field + " LIKE ? AND REG_DATE > ? AND"
				+ "    REG_DATE < (SELECT TO_DATE(?, 'YY-MM-DD')+1 FROM DUAL)) P)";

		List<PetPlaceView> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setString(2, startDate);
			st.setString(3, endDate);
			ResultSet rs = st.executeQuery();

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
						content, regDate, files, hit, likes, pub, num, reviewCount, avgRating, writerName,
						categoryName);

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

	@Override
	public List<PetPlaceView> getViewList(String field, String query) {
		String sql = "SELECT * FROM"
				+ "(SELECT ROWNUM NUM2, P.* FROM"
				+ "(SELECT * FROM PETPLACE_VIEW"
				+ "    WHERE " + field + " LIKE ? ) P)";

		List<PetPlaceView> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			ResultSet rs = st.executeQuery();

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
						content, regDate, files, hit, likes, pub, num, reviewCount, avgRating, writerName,
						categoryName);

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

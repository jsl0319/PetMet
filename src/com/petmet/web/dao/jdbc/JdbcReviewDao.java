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

import com.petmet.web.dao.ReviewDao;
import com.petmet.web.entity.Review;

public class JdbcReviewDao implements ReviewDao {

	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(Review review) {

		int result = 0;

		String sql = "INSERT INTO REVIEW(WRITER_ID, PETPLACE_ID, RATING, CONTENT, FILES) VALUES(?,?,?,?,?)";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, review.getWriterId());
			st.setInt(2, review.getPetPlaceId());
			st.setInt(3, review.getRating());
			st.setString(4, review.getContent());
			st.setString(5, review.getFiles());

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
	public int update(Review review) {
		int result = 0;

		String sql = "UPDATE REVIEW SET RATING=?,CONTENT=? WHERE ID=?";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, review.getRating());
			st.setString(2, review.getContent());

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

		String sql = "DELETE FROM REVIEW WHERE ID=?";

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
	public Review get(int id) {
		Review review = null;

		String sql = "SELECT * FROM REVIEW WHERE ID=" + id;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				int writerId = rs.getInt("WRITER_ID");
				int petPlaceId = rs.getInt("PETPLACE_ID");
				int rating = rs.getInt("RATING");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");
				String files = rs.getString("FILES");

				review = new Review(id, writerId, petPlaceId, rating, regDate, content, files);
			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return review;
	}

	@Override
	public List<Review> getList() {

		String sql = "SELECT * FROM REVIEW";

		List<Review> list = new ArrayList<>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				int id = rs.getInt("ID");
				int writerId = rs.getInt("WRITER_ID");
				int petPlaceId = rs.getInt("PETPLACE_ID");
				int rating = rs.getInt("RATING");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");
				String files = rs.getString("FILES");

				Review review = new Review(id, writerId, petPlaceId, rating, regDate, content, files);
				
				list.add(review);
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

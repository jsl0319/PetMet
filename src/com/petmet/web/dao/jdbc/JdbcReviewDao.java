package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			st.setString(1, review.getWriterId());
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
	
			return 0;
	}

	@Override
	public int delete(int id) {

		return 0;
	}

	@Override
	public Review get(int id) {

		return null;
	}

	@Override
	public List<Review> getList() {

		return null;
	}

}

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

import com.petmet.web.dao.DogDao;
import com.petmet.web.entity.Dog;
import com.petmet.web.entity.MatchingView;

public class JdbcDogDao implements DogDao {

	@Override
	public Dog get(int id) {
		Dog dog = null;
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT * FROM DOG WHERE ID=" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String name = rs.getString("NAME");
				String kind = rs.getString("KIND");
				int gender = rs.getInt("GENDER");
				int neut = rs.getInt("NEUT");
				Date birth = rs.getDate("BIRTH");
				int weight = rs.getInt("WEIGHT");
				String content = rs.getString("CONTENT");
				String character = rs.getString("CHARACTER");
				String files = rs.getString("FILES");
				String masterId = rs.getString("MASTER_ID");
				Date regDate = rs.getDate("REG_DATE");

				dog = new Dog(id, name, kind, gender, neut, birth, weight, content, character, files, masterId,
						regDate);

			}

			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return dog;
	}

	@Override
	public List<Dog> getList(String field, String query, String query2, int startIndex, int endIndex) {
		List<Dog> list = new ArrayList<>();

		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT * FROM " + 
				"(SELECT ROWNUM NUM,D.* FROM " + 
				"(SELECT * FROM DOG " + 
				"WHERE "+field+" LIKE ? AND "+"KIND LIKE ?"+ 
				" ORDER BY REG_DATE DESC) D)" + 
				"WHERE NUM BETWEEN ? AND ?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setString(2, "%"+query2+"%");
			st.setInt(3, startIndex);
			st.setInt(4, endIndex);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String kind = rs.getString("KIND");
				int gender = rs.getInt("GENDER");
				int neut = rs.getInt("NEUT");
				Date birth = rs.getDate("BIRTH");
				int weight = rs.getInt("WEIGHT");
				String content = rs.getString("CONTENT");
				String character = rs.getString("CHARACTER");
				String files = rs.getString("FILES");
				String masterId = rs.getString("MASTER_ID");
				Date regDate = rs.getDate("REG_DATE");

				Dog dog = new Dog(id, name, kind, gender, neut, birth, weight, content, character, files, masterId,
						regDate);
				list.add(dog);
	
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
	public int getCount(String field, String query, String query2) {

		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT COUNT(ID) COUNT FROM " + 
				"(SELECT ROWNUM NUM,D.* FROM " + 
				"(SELECT * FROM DOG " + 
				"WHERE KIND LIKE ?"+
				" ORDER BY REG_DATE DESC) D)";
			
		int count =0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query2+"%");
			ResultSet rs = st.executeQuery();

			if (rs.next()) 
				count = rs.getInt("COUNT");

		
		

			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return count;
	}

}

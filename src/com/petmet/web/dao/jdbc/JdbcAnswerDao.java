package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.petmet.web.dao.AnswerDao;
import com.petmet.web.entity.Answer;

public class JdbcAnswerDao implements AnswerDao{
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(Answer answer) {
		int result = 0;

		String sql = "INSERT INTO ANSWER(CONTENT) VALUES(?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);

			
			pst.setString(1, answer.getContent());
			

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Answer answer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Answer get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> getList() {
		// TODO Auto-generated method stub
		return null;
	}


	}



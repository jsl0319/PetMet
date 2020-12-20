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

import com.petmet.web.dao.AnswerDao;
import com.petmet.web.entity.Answer;


public class JdbcAnswerDao implements AnswerDao{
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(Answer answer) {
		int result = 0;

		String sql = "INSERT INTO ANSWER(QUESTION_ID,WRITER_ID,CONTENT) VALUES(?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);

			
			pst.setInt(1, answer.getQuestionId());
			pst.setString(2, answer.getWriterId());
			pst.setString(3, answer.getContent());
			

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
		int result = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "UPDATE ANSWER SET CONTENT=? WHERE QUESTION_ID =?";
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 연결
			Connection con = DriverManager.getConnection(url, uid, pwd);

			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, answer.getContent());
			st.setInt(2, answer.getQuestionId());

			result = st.executeUpdate();
			st.close();
			con.close();

//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Answer get(int id) {
		Answer a = null;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM ANSWER WHERE QUESTION_ID=" + id;
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				// int id = rs.getInt("id");
				
				int questionId = rs.getInt("QUESTION_ID");
				String writerId = rs.getString("WRITER_ID");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REG_DATE");
				a = new Answer(id, writerId, content, regDate);

			}
			;

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;

		
	
	}

	@Override
	public List<Answer> getList() {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM ANSWER ";
		Connection con;
		List<Answer> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, uid, pwd);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				int questionId = rs.getInt("QUESTION_ID");
				String writerId = rs.getString("WRITER_ID");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REG_DATE");
			Answer a = new Answer(questionId, writerId, content, regDate);


				list.add(a);
			}
			;

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
		
		


	}



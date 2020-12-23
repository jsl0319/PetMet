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

import com.petmet.web.dao.QuestionDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.Notice;
import com.petmet.web.entity.Question;

public class JdbcQuestionDao implements QuestionDao {
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;


	@Override
	public int insert(Question question) {
		int result = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "INSERT INTO QUESTION(TITLE,CONTENT) VALUES(?,?)";
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 연결
			Connection con = DriverManager.getConnection(url, uid, pwd);

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, question.getTitle());
			st.setString(2, question.getContent());

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
	public int update(Question question) {
		int result = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "UPDATE QUESTION SET TITLE=?,CONTENT=? WHERE ID =?";
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 연결
			Connection con = DriverManager.getConnection(url, uid, pwd);

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, question.getTitle());
			st.setString(2, question.getContent());
			
			st.setInt(3, question.getId());

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
	public int delet(int id) {
		int result = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "DELETE FROM NOTICE WHERE ID =?";
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 연결
			Connection con = DriverManager.getConnection(url, uid, pwd);

			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

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
	public Question get(int id) {
		Question q = null;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM QUESTION WHERE ID=" + id;
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {


			//	int id = rs.getInt("ID");
				String writerId = rs.getString("WRITER_ID");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String pub = rs.getString("PUB");
				Date regdate = rs.getDate("REG_DATE");
				String isAnswer = rs.getString("IS_ANSWER");
				Date anDate = rs.getDate("AN_DATE");

				 q = new Question(id, writerId, title, content, pub, regdate,isAnswer,anDate);

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
		return q;
	}

//	@Override
//	public List<Question> getList() {
//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT * FROM QUESTION";
//		Connection con;
//		List<Question> list = new ArrayList<>();
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection(url, uid, pwd);
//
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//
//			while (rs.next()) {
//
//				int id = rs.getInt("ID");
//				String writerId = rs.getString("WRITER_ID");
//				String title = rs.getString("TITLE");
//				String content = rs.getString("CONTENT");
//				int pub = rs.getInt("PUB");
//				Date regdate = rs.getDate("REG_DATE");
//				String isAnswer = rs.getString("IS_ANSWER");
//				Date anDate = rs.getDate("AN_DATE");
//
//				Question q = new Question(id, writerId, title, content, pub, regdate,isAnswer,anDate);
//
//				list.add(q);
//			}
//			;
//
//			rs.close();
//			st.close();
//			con.close();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}

	@Override
	public int updateAnswer(Question q) {
		int result = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "UPDATE QUESTION SET IS_ANSWER='"+"답변완료"+"'WHERE ID="+q.getId();
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 연결
			Connection con = DriverManager.getConnection(url, uid, pwd);

			PreparedStatement st = con.prepareStatement(sql);
			

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
	public List<Question> getList(String query, String startDate, String endDate, int startIndex, int endIndex) {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * "
				+ "FROM("
				+ "    SELECT ROWNUM NUM, N.* "
				+ "    FROM("
				+ "        SELECT * FROM QUESTION ORDER BY REG_DATE DESC"
				+ "    ) N"
				+ "		WHERE TITLE LIKE '%" + query + "%'"
				+ " 	AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'" 
				+ ") "
				+ "WHERE NUM BETWEEN '"+startIndex+"' AND '"+endIndex+"' ";
				
				
			

		List<Question> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String writerId = rs.getString("WRITER_ID");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String pub = rs.getString("PUB");
				Date regdate = rs.getDate("REG_DATE");
				String isAnswer = rs.getString("IS_ANSWER");
				Date anDate = rs.getDate("AN_DATE");

				Question q = new Question(id, writerId, title, content, pub, regdate,isAnswer,anDate);

				list.add(q);

			}
			;
			rs.close();
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
		return list;
	}

	@Override
	public int getCount(String query, String startDate, String endDate) {
		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;

		String sql = "SELECT COUNT(ID) COUNT FROM "
						+ "(SELECT ROWNUM NUM,M.* FROM "
						+ "(SELECT * FROM QUESTION "
						+ "WHERE TITLE LIKE ? AND "
						+ "REG_DATE>? AND "
						+ "REG_DATE<(SELECT TO_DATE(?,'YY-MM-DD')+1 FROM DUAL)"
						+ " ORDER BY REG_DATE DESC) M ) ";
						

		int count = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setString(3, startDate);
			st.setString(4, endDate);
			ResultSet rs = st.executeQuery();

			if(rs.next())
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

	@Override
	public List<Question> getList() {
		// TODO Auto-generated method stub
		return null;
	}


	

}

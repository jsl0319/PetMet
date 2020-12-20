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

import com.petmet.web.dao.NoticeDao;

import com.petmet.web.entity.Notice;

public class JdbcNoticeDao implements NoticeDao {
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;

	@Override
	public int insert(Notice notice) {
		int result = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "INSERT INTO NOTICE(ID,TITLE,CONTENT,WRITERID) VALUES(?,?,?,?)";
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 연결
			Connection con = DriverManager.getConnection(url, uid, pwd);

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, notice.getId());
			st.setString(2, notice.getTitle());
			st.setString(3, notice.getContent());
			st.setString(4, notice.getWriterId());

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
	public int update(Notice notice) {
		int result = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "UPDATE NOTICE SET TITLE=?,CONTENT=? WHERE ID =?";
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 연결
			Connection con = DriverManager.getConnection(url, uid, pwd);

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setInt(3, notice.getId());

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
	public int delete(int id) {
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
	public Notice get(int id) {
		Notice n = null;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID=" + id;
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				// int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Boolean pub = rs.getBoolean("pub");
				int hit = rs.getInt("hit");

				String writerId = rs.getString("writerid");
				Date regdate = rs.getDate("regdate");

				String files = rs.getString("files");
				n = new Notice(id, title, content, hit, writerId, regdate, files);

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
		return n;

	}

	@Override
	public Notice getLastId() {
		Notice n = null;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE ID = (SELECT MAX(ID) FROM NOTICE)";
		// Connection con;
		// List<Notice> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				String writerId = rs.getString("writerid");
				Date regdate = rs.getDate("regdate");
				String files = rs.getString("files");

				n = new Notice(id, title, content, hit, writerId, regdate, files);

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
		return n;
	}

//

//
//	@Override
//	public List<Notice> getList() {
//		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT * FROM NOTICE ";
//		Connection con;
//		List<Notice> list = new ArrayList<>();
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection(url, uid, pwd);
//
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//
//			while (rs.next()) {
//
//				int id = rs.getInt("id");
//				String title = rs.getString("title");
//				String content = rs.getString("content");
//				Boolean pub = rs.getBoolean("pub");
//				int hit = rs.getInt("hit");
//
//				String writerId = rs.getString("writerid");
//				Date regdate = rs.getDate("regdate");
//
//				String files = rs.getString("files");
//
//				Notice n = new Notice(id, title, content,  hit, writerId, regdate, files);
//
//				list.add(n);
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
//

	@Override
	public List<Notice> getList(String query, String startDate, String endDate, int page, int num) {

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE TITLE LIKE '%" + query + "%' AND " + "REGDATE>'" + startDate + "' AND "
				+ "REGDATE<(SELECT TO_DATE('" + endDate + "','YY-MM-DD')+1 FROM DUAL)";

		List<Notice> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				String writerId = rs.getString("writerid");
				Date regdate = rs.getDate("regdate");
				String files = rs.getString("files");

				Notice n = new Notice(id, title, content, hit, writerId, regdate, files);

				list.add(n);

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
	public int getdelNotceAll(int[] ids) {
		int result = 0;

		String params = "";

		for (int i = 0; i < ids.length; i++) {
			params += ids[i];

			if (i < ids.length - 1) //
				params += ",";
		}

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "DELETE FROM NOTICE WHERE ID IN (" + params + ")";
		List<Notice> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			Statement st = con.createStatement();

			result = st.executeUpdate(sql);

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

}

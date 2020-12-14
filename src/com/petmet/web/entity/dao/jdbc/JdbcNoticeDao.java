package com.petmet.web.entity.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.petmet.web.entity.Notice;
import com.petmet.web.entity.dao.NoticeDao;

public class JdbcNoticeDao implements NoticeDao{

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		int result = 0;

		String url = DBContext.URL;
		String uid = DBContext.UID;
		String pwd = DBContext.PWD;
		String sql = "UPDATE NOTICE SET TITLE=?,CONTENT=? WHERE ID=?";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setInt(3, notice.getId());

			result = st.executeUpdate();

			st.close();
			con.close();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteList(List<Integer> ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Notice> getList(int category, String searchContent, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(int pubId, boolean pub, boolean nonPub, int page) {
		
		return null;
	}

	@Override
	public List<Notice> getList(int pubId, boolean pub, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(Date startDate, Date endDate, int page) {
		getList(0,null,false,false,startDate,endDate,page);
		return null;
	}

	@Override
	public List<Notice> getList(int category, String searchContent, boolean pub, boolean nonPub, Date startDate,
			Date endDate, int page) {
		
		return null;
	}

	@Override
	public List<Notice> pubList(List<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notice> getList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

}

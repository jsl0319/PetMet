package com.petmet.web.shop.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petmet.web.shop.entity.Order;

public class OrderService {
	private String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	private String uid = "petmet";
	private String pw = "0000";
	
	// -------------------------------------- Select --------------------------------------
	public List<Order> getList() {
		String sql = "SELECT * FROM ORDERS";

		List<Order> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
			    String userId = rs.getNString("user_id");
			    Date payDate = rs.getDate("paydate");
			    String productName = rs.getNString("productname");
			    int payAmount = rs.getInt("payamount");
			    String payMethod = rs.getNString("paymethod");
			    String payStatement = rs.getNString("pay_statement");
			    String deliveryStatement = rs.getNString("delivery_statement");
			    String refund = rs.getNString("refund");
			    
			    Order order = new Order(id, userId, payDate, productName, payAmount, payMethod, payStatement, deliveryStatement, refund);
				list.add(order);
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

	// -------------------------------------- get --------------------------------------
	public Order get(int id) {

		Order order = null;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM ORDER WHERE ID =" + id;
		

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pw);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
			    String userId = rs.getNString("user_id");
			    Date payDate = rs.getDate("paydate");
			    String productName = rs.getNString("productname");
			    int payAmount = rs.getInt("payamount");
			    String payMethod = rs.getNString("paymethod");
			    String payStatement = rs.getNString("pay_statement");
			    String deliveryStatement = rs.getNString("delivery_statement");
			    String refund = rs.getNString("refund");
			    
				order = new Order(id, userId, payDate, productName, payAmount, payMethod, payStatement, deliveryStatement, refund);
			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return order;
	}
}

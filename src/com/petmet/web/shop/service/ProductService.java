package com.petmet.web.shop.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.petmet.web.shop.entity.Product;



public class ProductService {

	public List<Product> getList() {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	    String sql = "SELECT * FROM \"PRODUCT\"";
	    String user = "petmet";
	    String pwd = "0000";

	     // Class.forName("oracle.jdbc.driver.OracleDriver");
	      List<Product> list = new ArrayList<>();

	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	          Connection con = DriverManager.getConnection(url,user,pwd);
	          Statement st = con.createStatement();
	          ResultSet rs = st.executeQuery(sql);
	         
	         
	         while(rs.next()){
	        	int id = rs.getInt("id");
	        	int price = rs.getInt("price");
	        	int amount = rs.getInt("amount");
	        	String posted = rs.getNString("posted");
	        	String name = rs.getNString("name");
	        	String imgPath = rs.getNString("img_path");
	        	String regdate = rs.getNString("regdate");
	        	
	        	
	        	Product p = new Product(id, price, amount, posted, name, imgPath, regdate);
	        	
	        	list.add(p);
	         }
	         
	         rs.close();
	         st.close();
	         con.close();
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return list;
		}
}

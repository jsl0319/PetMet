package com.petmet.web.dao.jdbc;

public class DBContext {
	public final static String URL;
	public final static String UID;
	public final static String PWD;
	
	static {
		URL = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		UID = "petmet";
		PWD = "0000";
	}
}

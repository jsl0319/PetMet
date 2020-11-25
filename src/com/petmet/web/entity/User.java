package com.petmet.web.entity;

public class User {

	public int	id;
	private String uid;
	private String pwd;
	private String name;
	private String birthday;


public User() {
//	this(0,null,null,null,null);
}
	
	public User(int id, String uid, String pwd, String name, String birthday) {
		super();
		this.id = id;
		this.uid = uid;
		this.pwd = pwd;
		this.name = name;
		this.birthday = birthday;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", uid=" + uid + ", pwd=" + pwd + ", name=" + name + ", birthday=" + birthday + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}


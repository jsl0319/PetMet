package com.petmet.web.entity;

public class User {
	// ------------------------ Attribute ------------------------
	private int id;
	private String name;
	private String uid;
	private String pwd;
	private String birthday;
	
	// ------------------------ Constructor ------------------------
	public User() {
		this(0, null, null, null, null);
	}

	public User(int id, String name, String uid, String pwd, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.uid = uid;
		this.pwd = pwd;
		this.birthday = birthday;
	}
	//a메렁
	// ------------------------ Getters/Setters ------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	// ------------------------ Functions ------------------------
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", uid=" + uid + ", pwd=" + pwd + ", birthday=" + birthday + "]";
	}
	
}
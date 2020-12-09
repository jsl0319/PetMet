package com.petmet.web.entity;

public class Admin {
	 private int id;
	 private String email;
	 private String pwd;
	 private String nickname;
	 
	 public Admin() {
		this(0,null,null,null);
	}

	public Admin(int id, String email, String pwd, String nickname) {
		this.id = id;
		this.email = email;
		this.pwd = pwd;
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", pwd=" + pwd + ", nickname=" + nickname + "]";
	}
	
	
	 
}

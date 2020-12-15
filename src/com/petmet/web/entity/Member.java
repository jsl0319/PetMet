package com.petmet.web.entity;

import java.util.Date;

public class Member {

	private int id;
	private String email;
	private String pwd;
	private String nickname;
	private int gender;
	private String address;
	private String phone;
	private Date regDate;

	public Member() {
		this(0,null,null,null,0,null,null,null);
		
	}

	public Member(int id, String email, String pwd, String nickname, int gender, String address, String phone,
			Date regDate) {
		this.id = id;
		this.email = email;
		this.pwd = pwd;
		this.nickname = nickname;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.regDate = regDate;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", pwd=" + pwd + ", nickname=" + nickname + ", gender="
				+ gender + ", address=" + address + ", phone=" + phone + ", regDate=" + regDate + "]";
	}
	

}
package com.petmet.web.entity;

import java.util.Date;

public class PetPlace {
	private int id;
	private String writerId;
	private String categoryId;
	private String name;
	private String address;
	private String homepage;
	private String phone;
	private String location;
	private String content;
	private Date regDate;
	private String files;
	private int hit;
	private int likes;
	private int pub;

	public PetPlace() {
		
	}

	// insert용 생성자
	public PetPlace(String categoryId, String name, String address, String homepage, String phone,
			String location, String content, String files) {
		this.categoryId = categoryId;
		this.name = name;
		this.address = address;
		this.homepage = homepage;
		this.phone = phone;
		this.location = location;
		this.content = content;
		this.files = files;
	}

	public PetPlace(int id, String writerId, String categoryId, String name, String address, String homepage,
			String phone, String location, String content, Date regDate, String files, int hit, int likes, int pub) {
		super();
		this.id = id;
		this.writerId = writerId;
		this.categoryId = categoryId;
		this.name = name;
		this.address = address;
		this.homepage = homepage;
		this.phone = phone;
		this.location = location;
		this.content = content;
		this.regDate = regDate;
		this.files = files;
		this.hit = hit;
		this.likes = likes;
		this.pub = pub;
	}
	
	

	@Override
	public String toString() {
		return "PetPlace [id=" + id + ", writerId=" + writerId + ", categoryId=" + categoryId + ", name=" + name
				+ ", address=" + address + ", homepage=" + homepage + ", phone=" + phone + ", location=" + location
				+ ", content=" + content + ", regDate=" + regDate + ", files=" + files + ", hit=" + hit + ", likes="
				+ likes + ", pub=" + pub + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getPub() {
		return pub;
	}

	public void setPub(int pub) {
		this.pub = pub;
	}

}
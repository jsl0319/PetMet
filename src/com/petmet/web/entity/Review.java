package com.petmet.web.entity;

import java.sql.Date;

public class Review {
	private int id;
	private String writerId;
	private int petplaceId;
	private String rating;
	private Date regDate;
	private String content;
	private String files;
	
	public Review() {
		this(0, null, 0, null, null, null, null);
	}
	
	public Review(int id, String writerId, int petplaceId, String rating, Date regDate, String content, String files) {
		super();
		this.id = id;
		this.writerId = writerId;
		this.petplaceId = petplaceId;
		this.rating = rating;
		this.regDate = regDate;
		this.content = content;
		this.files = files;
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
	public int getPetplaceId() {
		return petplaceId;
	}
	public void setPetplaceId(int petplaceId) {
		this.petplaceId = petplaceId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", writerId=" + writerId + ", petplaceId=" + petplaceId + ", rating=" + rating
				+ ", regDate=" + regDate + ", content=" + content + ", files=" + files + "]";
	}
	
}

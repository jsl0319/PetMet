package com.petmet.web.entity;

import java.sql.Date;

public class Question {
	 private int id;
	 private String	writerId;
	 private String	title;
	 private String	content;
	 private int pub;
	 private Date regDate;
	 
	 public Question() {
		this(0, null, null, null, 0, null);
	}
	
	 
	public Question(int id, String writerId, String title, String content, int pub, Date regDate) {
		super();
		this.id = id;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.pub = pub;
		this.regDate = regDate;
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
	
	
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public int getPub() {
		return pub;
	}
	
	
	public void setPub(int pub) {
		this.pub = pub;
	}
	
	
	public Date getRegDate() {
		return regDate;
	}
	
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", writerId=" + writerId + ", title=" + title + ", content=" + content + ", pub="
				+ pub + ", regDate=" + regDate + "]";
	}
	 
}

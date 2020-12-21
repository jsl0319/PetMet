package com.petmet.web.entity;

import java.util.Date;

public class Question {
	 private int id;
	 private String	writerId;
	 private String	title;
	 private String	content;
	 private int pub;
	 private Date regDate;
	 private String isAnswer;
	 private Date anDate;
	 
	 public Question() {
		
	}
	
	 
	
	
	
	public Question(int id, String writerId, String title, String content, int pub, Date regDate, String isAnswer,
			Date anDate) {
	
		this.id = id;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.pub = pub;
		this.regDate = regDate;
		this.isAnswer = isAnswer;
		this.anDate = anDate;
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
	
	
	
	
	public String getIsAnswer() {
		return isAnswer;
	}





	public void setIsAnswer(String isAnswer) {
		this.isAnswer = isAnswer;
	}





	public Date getAnDate() {
		return anDate;
	}





	public void setAnDate(Date anDate) {
		this.anDate = anDate;
	}





	@Override
	public String toString() {
		return "Question [id=" + id + ", writerId=" + writerId + ", title=" + title + ", content=" + content + ", pub="
				+ pub + ", regDate=" + regDate + ", isAnswer=" + isAnswer + ", anDate=" + anDate + "]";
	}





}

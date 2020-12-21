package com.petmet.web.entity;

import java.util.Date;

public class QnAListView {
	   private int id;
	   private String title;
	   private String writerId;
	   private Date regDate;
	   private Boolean pub;
	   private Boolean isAnswer;
	   private Date answerDate;
	   
	   public QnAListView() {
		
	}

	public QnAListView(int id, String title, String writerId, Date regDate, Boolean pub, Boolean isAnswer,
			Date answerDate) {
	
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.regDate = regDate;
		this.pub = pub;
		this.isAnswer = isAnswer;
		this.answerDate = answerDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Boolean getPub() {
		return pub;
	}

	public void setPub(Boolean pub) {
		this.pub = pub;
	}

	public Boolean getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(Boolean isAnswer) {
		this.isAnswer = isAnswer;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	@Override
	public String toString() {
		return "QnAListView [id=" + id + ", title=" + title + ", writerId=" + writerId + ", regDate=" + regDate
				+ ", pub=" + pub + ", isAnswer=" + isAnswer + ", answerDate=" + answerDate + "]";
	}
	   

}

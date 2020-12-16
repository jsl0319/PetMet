package com.petmet.web.entity;

import java.util.Date;

public class QnAView extends Notice {
	private int id;
	private String writerId;
	private String title;
	private String content;
	private int pub;
	private Date regDate;
	private String answerContent;
	private Date answerDate;

	
	public QnAView() {
		// TODO Auto-generated constructor stub
	}
	
	
	



	public QnAView(String title, String content, int id, String writerId, String title2, String content2, int pub,
			Date regDate, String answerContent, Date answerDate) {
		super(title, content);
		this.id = id;
		this.writerId = writerId;
		title = title2;
		content = content2;
		this.pub = pub;
		this.regDate = regDate;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
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

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	@Override
	public String toString() {
		return "NoticeView [id=" + id + ", writerId=" + writerId + ", title=" + title + ", content=" + content
				+ ", pub=" + pub + ", regDate=" + regDate + ", answerContent=" + answerContent + ", answerDate="
				+ answerDate + "]";
	}
	
	
	
}

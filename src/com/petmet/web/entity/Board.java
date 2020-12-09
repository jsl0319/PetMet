package com.petmet.web.entity;

import java.util.Date;

public class Board {
	private int id;
	private String title;
	private String content;
	private int hit;
	private String writerId;
	private Date regDate;
	private String files;
	private String categoryId;
	
	public Board() {
		this(0,null,null,0,null,null,null,null);
	}

	public Board(int id, String title, String content, int hit, String writerId, Date regDate, String files,
			String categoryId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.writerId = writerId;
		this.regDate = regDate;
		this.files = files;
		this.categoryId = categoryId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
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

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", hit=" + hit + ", writerId="
				+ writerId + ", regDate=" + regDate + ", files=" + files + ", categoryId=" + categoryId + "]";
	}
	
}

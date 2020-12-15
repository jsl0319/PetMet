package com.petmet.web.entity;

import java.util.Date;

public class BoardReportView {
	private int num;
    private int id;
    private String title;
    private int hit;
    private String writerId;
    private Date regDate;
    private String files;
    private String categoryId;
    private int reported;
    
    public BoardReportView() {
    	this(0, 0, null, 0, null, null, null, null, 0);
	}

	public BoardReportView(int num, int id, String title, int hit, String writerId, Date regDate, String files,
			String categoryId, int reported) {
		this.num = num;
		this.id = id;
		this.title = title;
		this.hit = hit;
		this.writerId = writerId;
		this.regDate = regDate;
		this.files = files;
		this.categoryId = categoryId;
		this.reported = reported;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public int getReported() {
		return reported;
	}

	public void setReported(int reported) {
		this.reported = reported;
	}

	@Override
	public String toString() {
		return "BoardReportView [num=" + num + ", id=" + id + ", title=" + title + ", hit=" + hit + ", writerId="
				+ writerId + ", regDate=" + regDate + ", files=" + files + ", categoryId=" + categoryId + ", reported="
				+ reported + "]";
	}
    
}

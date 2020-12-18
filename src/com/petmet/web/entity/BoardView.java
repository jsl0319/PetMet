package com.petmet.web.entity;

import java.util.Date;

public class BoardView {
	private int num;
	private int id;
	private String title;
	private int hit;
	private String writerId;
	private Date regDate;
	private String files;
	private int categoryId;
    private String categoryName;
	private int cmtCnt;

	public BoardView() {
		this(0, 0, null, 0, null, null, null, 0, null, 0);
	}

	public BoardView(int num, int id, String title, int hit, String writerId, Date regDate, String files,
			int categoryId, String categoryName, int cmtCnt) {
		this.num = num;
		this.id = id;
		this.title = title;
		this.hit = hit;
		this.writerId = writerId;
		this.regDate = regDate;
		this.files = files;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.cmtCnt = cmtCnt;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCmtCnt() {
		return cmtCnt;
	}

	public void setCmtCnt(int cmtCnt) {
		this.cmtCnt = cmtCnt;
	}

	@Override
	public String toString() {
		return "BoardView [num=" + num + ", id=" + id + ", title=" + title + ", hit=" + hit + ", writerId=" + writerId
				+ ", regDate=" + regDate + ", files=" + files + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", cmtCnt=" + cmtCnt + "]";
	}
	
}

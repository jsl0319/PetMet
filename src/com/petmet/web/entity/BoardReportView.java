package com.petmet.web.entity;

import java.util.Date;

public class BoardReportView {
	private int num;
    private int boardId;
    private String writerId;
    private int categoryId;
    private String categoryName;
    private String title;
    private Date regDate;
    private int hit;
    private int reported;
    
    public BoardReportView() {
		this(0, 0, null, 0, null, null, null, 0, 0);
	}

	public BoardReportView(int num, int boardId, String writerId, int categoryId, String categoryName, String title,
			Date regDate, int hit, int reported) {
		this.num = num;
		this.boardId = boardId;
		this.writerId = writerId;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.title = title;
		this.regDate = regDate;
		this.hit = hit;
		this.reported = reported;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getReported() {
		return reported;
	}

	public void setReported(int reported) {
		this.reported = reported;
	}

	@Override
	public String toString() {
		return "BoardReportView [num=" + num + ", boardId=" + boardId + ", writerId=" + writerId + ", categoryId="
				+ categoryId + ", categoryName=" + categoryName + ", title=" + title + ", regDate=" + regDate + ", hit="
				+ hit + ", reported=" + reported + "]";
	}
    
}

package com.petmet.web.entity;

import java.util.Date;

public class CommentReportView {
	private int num;
    private int id;
    private String categoryId;
    private int boardId;
    private String title;
    private String writerId;
    private String content;
    private Date regDate;
    private int reported;
    
    public CommentReportView() {
    	this(0, 0, null, 0, null, null, null, null, 0);
	}

	public CommentReportView(int num, int id, String categoryId, int boardId, String title, String writerId,
			String content, Date regDate, int reported) {
		this.num = num;
		this.id = id;
		this.categoryId = categoryId;
		this.boardId = boardId;
		this.title = title;
		this.writerId = writerId;
		this.content = content;
		this.regDate = regDate;
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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
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

	public int getReported() {
		return reported;
	}

	public void setReported(int reported) {
		this.reported = reported;
	}

	@Override
	public String toString() {
		return "CommentReportView [num=" + num + ", id=" + id + ", categoryId=" + categoryId + ", boardId=" + boardId
				+ ", title=" + title + ", writerId=" + writerId + ", content=" + content + ", regDate=" + regDate
				+ ", reported=" + reported + "]";
	}
    
}

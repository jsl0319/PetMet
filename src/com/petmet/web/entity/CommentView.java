package com.petmet.web.entity;

import java.util.Date;

public class CommentView {
	private int num;
    private int id;
    private String categoryId;
    private int boardId;
    private String title;
    private String writerId;
    private String content;
    private Date regDate;
    
    public CommentView() {
		this(0, 0, null, 0, null, null, null, null);
	}

	public CommentView(int num, int id, String categoryId, int boardId, String title, String writerId, String content,
			Date regDate) {

		this.num = num;
		this.id = id;
		this.categoryId = categoryId;
		this.boardId = boardId;
		this.title = title;
		this.writerId = writerId;
		this.content = content;
		this.regDate = regDate;
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

	@Override
	public String toString() {
		return "Comment_View [num=" + num + ", id=" + id + ", categoryId=" + categoryId + ", boardId=" + boardId
				+ ", title=" + title + ", writerId=" + writerId + ", content=" + content + ", regDate=" + regDate + "]";
	}
    
}

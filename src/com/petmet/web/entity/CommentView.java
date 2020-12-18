package com.petmet.web.entity;

import java.util.Date;

public class CommentView {
	private int num;
    private int id;
    private int categoryId;
    private String categoryName;
    private int boardId;
    private String title;
    private String writerId;
    private String content;
    private Date regDate;
    
    public CommentView() {
		this(0, 0, 0, null, 0, null, null, null, null);
	}

	public CommentView(int num, int id, int categoryId, String categoryName, int boardId, String title, String writerId,
			String content, Date regDate) {
		this.num = num;
		this.id = id;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
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
		return "CommentView [num=" + num + ", id=" + id + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", boardId=" + boardId + ", title=" + title + ", writerId=" + writerId + ", content="
				+ content + ", regDate=" + regDate + "]";
	}
    
}

package com.petmet.web.entity;

import java.util.Date;

public class Comments {

	private int id;
	private String writerId;
	private int boardId;
	private String content;
	private Date reg_date;

	public Comments() {
		this(0, null, 0, null, null);
	}

	public Comments(int id, String writerId, int boardId, String content, Date reg_date) {
		this.id = id;
		this.writerId = writerId;
		this.boardId = boardId;
		this.content = content;
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", writerId=" + writerId + ", boardId=" + boardId + ", content=" + content
				+ ", reg_date=" + reg_date + "]";
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

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

}

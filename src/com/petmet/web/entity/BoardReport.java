package com.petmet.web.entity;

import java.util.Date;

public class BoardReport {

	private int id;
	private String memId;
	private int boardId;
	private Date regDate;
	private String content;

	public BoardReport() {
		this(0, null, 0, null, null);
	}

	public BoardReport(int id, String memId, int boardId, Date regDate, String content) {
		this.id = id;
		this.memId = memId;
		this.boardId = boardId;
		this.regDate = regDate;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardReport [id=" + id + ", memId=" + memId + ", boardId=" + boardId + ", regDate=" + regDate
				+ ", content=" + content + "]";
	}

}

package com.petmet.web.entity;

import java.util.Date;

public class CommentReport {

	private int id;
	private String memId;
	private int commentId;
	private Date regDate;
	private String content;

	public CommentReport() {
		this(0, null, 0, null, null);
	}

	public CommentReport(int id, String memId, int commentId, Date regDate, String content) {
		this.id = id;
		this.memId = memId;
		this.commentId = commentId;
		this.regDate = regDate;
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentReport [id=" + id + ", memId=" + memId + ", commentId=" + commentId + ", regDate=" + regDate
				+ ", content=" + content + "]";
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

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

}

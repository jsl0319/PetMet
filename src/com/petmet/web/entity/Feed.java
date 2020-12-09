package com.petmet.web.entity;

import java.util.Date;

public class Feed {
	private int id;
	private String content;
	private Date editDate;
	private String writerId;
	private Date regDate;
	private String files;

	public Feed() {
		this(0,null,null,null,null,null);

	}

	public Feed(int id, String content, Date editDate, String writerId, Date regDate, String files) {

		this.id = id;
		this.content = content;
		this.editDate = editDate;
		this.writerId = writerId;
		this.regDate = regDate;
		this.files = files;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
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

	public String getfiles() {
		return files;
	}

	public void setfiles(String files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Feed_Report [id=" + id + ", content=" + content + ", editDate=" + editDate + ", writerId="
				+ writerId + ", regDate=" + regDate + ", files=" + files + "]";
	}

}

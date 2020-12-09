package com.petmet.web.entity;

import java.util.Date;

public class Feed {
	private int id;
	private String content;
	private Date edit_date;
	private String writer_id;
	private Date reg_date;
	private String file;

	public Feed() {
		this(0,null,null,null,null,null);

	}

	public Feed(int id, String content, Date edit_date, String writer_id, Date reg_date, String file) {

		this.id = id;
		this.content = content;
		this.edit_date = edit_date;
		this.writer_id = writer_id;
		this.reg_date = reg_date;
		this.file = file;
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

	public Date getEdit_date() {
		return edit_date;
	}

	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Feed_Report [id=" + id + ", content=" + content + ", edit_date=" + edit_date + ", writer_id="
				+ writer_id + ", reg_date=" + reg_date + ", file=" + file + "]";
	}

}

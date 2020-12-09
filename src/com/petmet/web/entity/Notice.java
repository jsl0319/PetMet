package com.petmet.web.entity;

import java.util.Date;

public class Notice {
	
	private String title;
	private String  content;
	private int ispublic;
	private int  hit;
	private String writerId;
	private Date regdate;
	private String files;
	private int  id;
	
	
	public  Notice() {
		
	}


	public Notice(String title, String content, int ispublic, int hit, String writerId, Date regdate, String files,
			int id) {
		
		this.title = title;
		this.content = content;
		this.ispublic = ispublic;
		this.hit = hit;
		this.writerId = writerId;
		this.regdate = regdate;
		this.files = files;
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getIspublic() {
		return ispublic;
	}


	public void setIspublic(int ispublic) {
		this.ispublic = ispublic;
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


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public String getFiles() {
		return files;
	}


	public void setFiles(String files) {
		this.files = files;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Notice [title=" + title + ", content=" + content + ", ispublic=" + ispublic + ", hit=" + hit
				+ ", writerId=" + writerId + ", regdate=" + regdate + ", files=" + files + ", id=" + id + "]";
	}
	
	

}

package com.petmet.web.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String content;
	private int pub;
	private int hit;
	private String writerId;
	private Date regdate;
	private String files;

	
	public Notice() {
		
	}

	public Notice(int id,String title, String content, int pub, int hit, String writerId, Date regdate, String files
			) {

		this.title = title;
		this.content = content;
		this.pub = pub;
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

	public int getpub() {
		return pub;
	}

	public void setpub(int pub) {
		this.pub = pub;
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
		return "Notice [title=" + title + ", content=" + content + ", pub=" + pub + ", hit=" + hit
				+ ", writerId=" + writerId + ", regdate=" + regdate + ", files=" + files + ", id=" + id + "]";
	}

}

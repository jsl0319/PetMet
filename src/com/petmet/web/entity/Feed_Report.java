package com.petmet.web.entity;

import java.util.Date;

public class Feed_Report {
    private int id;
    private String mem_id;
    private String feed_id;
    private Date repo_date;
    private String content;
	
    
    public Feed_Report() {
    	this(0,null,null,null,null);
    }


	public Feed_Report(int id, String mem_id, String feed_id, Date repo_date, String content) {
		
		this.id = id;
		this.mem_id = mem_id;
		this.feed_id = feed_id;
		this.repo_date = repo_date;
		this.content = content;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMem_id() {
		return mem_id;
	}


	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	public String getFeed_id() {
		return feed_id;
	}


	public void setFeed_id(String feed_id) {
		this.feed_id = feed_id;
	}


	public Date getRepo_date() {
		return repo_date;
	}


	public void setRepo_date(Date repo_date) {
		this.repo_date = repo_date;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Feed_Report [id=" + id + ", mem_id=" + mem_id + ", feed_id=" + feed_id + ", repo_date=" + repo_date
				+ ", content=" + content + "]";
	}
	
	
}

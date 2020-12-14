package com.petmet.web.entity;

import java.util.Date;

public class FeedReport {
    private int id;
    private String memId;
    private String feedId;
    private Date repoDate;
    private String content;
    
    public FeedReport() {
		this(0,null,null,null,null);
	}

	public FeedReport(int id, String memId, String feedId, Date repoDate, String content) {
		this.id = id;
		this.memId = memId;
		this.feedId = feedId;
		this.repoDate = repoDate;
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

	public String getFeedId() {
		return feedId;
	}

	public void setFeedId(String feedId) {
		this.feedId = feedId;
	}

	public Date getRepoDate() {
		return repoDate;
	}

	public void setRepoDate(Date repoDate) {
		this.repoDate = repoDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "FeedReport [id=" + id + ", memId=" + memId + ", feedId=" + feedId + ", repoDate=" + repoDate
				+ ", content=" + content + "]";
	}

	
}

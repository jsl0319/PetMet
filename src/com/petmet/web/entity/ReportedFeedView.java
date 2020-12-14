package com.petmet.web.entity;

import java.util.Date;

public class ReportedFeedView extends FeedReport{
	private int id;
	private String memId;
	private String reportedId;
	private Date repoDate;
	private String repoContent;
	private int repoCnt;
	private String action;
	
	public ReportedFeedView() {
		this(0,null,null,null,null,0,null);
	}

	public ReportedFeedView(int id, String memId, String reportedId, Date repoDate, String repoContent, int repoCnt,
			String action) {
		this.id = id;
		this.memId = memId;
		this.reportedId = reportedId;
		this.repoDate = repoDate;
		this.repoContent = repoContent;
		this.repoCnt = repoCnt;
		this.action = action;
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

	public String getReportedId() {
		return reportedId;
	}

	public void setReportedId(String reportedId) {
		this.reportedId = reportedId;
	}

	public Date getRepoDate() {
		return repoDate;
	}

	public void setRepoDate(Date repoDate) {
		this.repoDate = repoDate;
	}

	public String getRepoContent() {
		return repoContent;
	}

	public void setRepoContent(String repoContent) {
		this.repoContent = repoContent;
	}

	public int getRepoCnt() {
		return repoCnt;
	}

	public void setRepoCnt(int repoCnt) {
		this.repoCnt = repoCnt;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "ReportedFeedView [id=" + id + ", memId=" + memId + ", reportedId=" + reportedId + ", repoDate="
				+ repoDate + ", repoContent=" + repoContent + ", repoCnt=" + repoCnt + ", action=" + action + "]";
	}

	
}

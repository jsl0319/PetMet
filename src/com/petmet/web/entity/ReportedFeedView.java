package com.petmet.web.entity;

import java.util.Date;

public class ReportedFeedView extends FeedReport{
	private int id;
	private int num;
	private String reportedId;
	private String files;
	private String content;
	private int repoCnt;
	private String action;
	
	public ReportedFeedView() {
		this(0,0,null,null,null,0,null);
	}

	public ReportedFeedView(int id, int num, String reportedId, String files, String content, int repoCnt,
			String action) {
		this.id = id;
		this.num = num;
		this.reportedId = reportedId;
		this.files = files;
		this.content = content;
		this.repoCnt = repoCnt;
		this.action = action;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getReportedId() {
		return reportedId;
	}

	public void setReportedId(String reportedId) {
		this.reportedId = reportedId;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "ReportedFeedView [id=" + id + ", num=" + num + ", reportedId=" + reportedId + ", files=" + files
				+ ", content=" + content + ", repoCnt=" + repoCnt + ", action=" + action + "]";
	}
	
	
}

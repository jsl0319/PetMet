package com.petmet.web.entity;

import java.util.Date;

public class MatchInfo {
	private int dogId;
	private Date regDate;
    private int regPub;
    private String content;
    
	//---------------------------------- Constructor ----------------------------------
    public MatchInfo() {
		this(0, null, 0, null);
	}

	public MatchInfo(int dogId, Date regDate, int regPub, String content) {
		this.dogId = dogId;
		this.regDate = regDate;
		this.regPub = regPub;
		this.content = content;
	}

	//---------------------------------- Getters/Setters ----------------------------------
	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRegPub() {
		return regPub;
	}

	public void setRegPub(int regPub) {
		this.regPub = regPub;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//---------------------------------- Functions ----------------------------------
	@Override
	public String toString() {
		return "MatchInfo [dogId=" + dogId + ", regDate=" + regDate + ", regPub=" + regPub + ", content=" + content
				+ "]";
	}
    
}

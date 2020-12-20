package com.petmet.web.entity;

import java.util.Date;

public class MatchingView extends Matching{
	private String reqDogName;
	private String respDogName;
	private String reqDogFiles;
	private String respDogFiles;
	private String matchContent;

	public MatchingView(int id, String reqId, String respId, int reqDogId,String reqDogName, String reqDogFiles,int respDogId, String respDogName, 
			String respDogFiles,Date reqDate, String result, String matchContent) {
		super(id, reqId, respId, reqDogId, respDogId, reqDate, result, null, null, null, null);
		this.reqDogName = reqDogName;
		this.respDogName = respDogName;
		this.reqDogFiles = reqDogFiles;
		this.respDogFiles = respDogFiles;
		this.matchContent = matchContent;
	}

	public String getReqDogName() {
		return reqDogName;
	}

	public void setReqDogName(String reqDogName) {
		this.reqDogName = reqDogName;
	}

	public String getRespDogName() {
		return respDogName;
	}

	public void setRespDogName(String respDogName) {
		this.respDogName = respDogName;
	}

	public String getReqDogFiles() {
		return reqDogFiles;
	}

	public void setReqDogFiles(String reqDogFiles) {
		this.reqDogFiles = reqDogFiles;
	}

	public String getRespDogFiles() {
		return respDogFiles;
	}

	public void setRespDogFiles(String respDogFiles) {
		this.respDogFiles = respDogFiles;
	}

	public String getMatchContent() {
		return matchContent;
	}

	public void setMatchContent(String matchContent) {
		this.matchContent = matchContent;
	}

	@Override
	public String toString() {
		return "MatchingView [reqDogName=" + reqDogName + ", respDogName=" + respDogName + ", reqDogFiles="
				+ reqDogFiles + ", respDogFiles=" + respDogFiles + ", matchContent=" + matchContent + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}

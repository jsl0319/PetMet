package com.petmet.web.entity;

import java.util.Date;

public class Matching {
	private int id;
	private String reqId;
	private String respId;
	private int reqDogId;
	private int respDogId;
	private Date reqDate;
    private String result;
    private Date resultDate;
    private String repId;
    private String repContent;
    private Date repDate;
    
  //---------------------------------- Constructor ----------------------------------
    public Matching() {
    	this(0, null, null,0,0,null, null, null, null, null,null);
	}

	public Matching(int id, String reqId, String respId,int reqDogId, int respDogId, Date reqDate, String result, Date resultDate, String repId,
			String repContent, Date repDate) {
		this.id = id;
		this.reqId = reqId;
		this.respId = respId;
		this.reqDogId = reqDogId;
		this.respDogId = respDogId;
		this.reqDate = reqDate;
		this.result = result;
		this.resultDate = resultDate;
		this.repId = repId;
		this.repContent = repContent;
		this.repDate = repDate;
	}

	//---------------------------------- Getters/Setters ----------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public String getRespId() {
		return respId;
	}

	public void setRespId(String respId) {
		this.respId = respId;
	}

	public int getReqDogId() {
		return reqDogId;
	}

	public void setReqDogId(int reqDogId) {
		this.reqDogId = reqDogId;
	}

	public int getRespDogId() {
		return respDogId;
	}

	public void setRespDogId(int respDogId) {
		this.respDogId = respDogId;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getResultDate() {
		return resultDate;
	}

	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	public String getRepContent() {
		return repContent;
	}

	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}

	public Date getRepDate() {
		return repDate;
	}

	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}

	public String getRepId() {
		return repId;
	}

	public void setRepId(String repId) {
		this.repId = repId;
	}



	//---------------------------------- Functions ----------------------------------


	@Override
	public String toString() {
		return "Matching [id=" + id + ", reqId=" + reqId + ", respId=" + respId + ", reqDogId=" + reqDogId
				+ ", respDogId=" + respDogId + ", reqDate=" + reqDate + ", result=" + result + ", resultDate="
				+ resultDate + ", repId=" + repId + ", repContent=" + repContent + ", repDate=" + repDate + "]";
	}

    
}

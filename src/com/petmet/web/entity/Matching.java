package com.petmet.web.entity;

import java.util.Date;

public class Matching {
	private int id;
	private String reqId;
	private String respId;
	private Date reqDate;
    private String result;
    private Date resultDate;
    private String repContent;
    private Date repDate;
    
  //---------------------------------- Constructor ----------------------------------
    public Matching() {
    	this(0, null, null,null, null, null, null, null);
	}

	public Matching(int id, String reqId, String respId, Date reqDate, String result, Date resultDate,
			String repContent, Date repDate) {
		this.id = id;
		this.reqId = reqId;
		this.respId = respId;
		this.reqDate = reqDate;
		this.result = result;
		this.resultDate = resultDate;
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

	//---------------------------------- Functions ----------------------------------
	@Override
	public String toString() {
		return "Matching [id=" + id + ", reqId=" + reqId + ", respId=" + respId + ", reqDate=" + reqDate + ", result="
				+ result + ", resultDate=" + resultDate + ", repContent=" + repContent + ", repDate=" + repDate + "]";
	}
    
    
}

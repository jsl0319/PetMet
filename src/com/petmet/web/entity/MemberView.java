package com.petmet.web.entity;

import java.util.Date;

public class MemberView extends Member{
	private int dogNum;
	private int mtReqNum;
	private int mtRespNum;
	private int mtSuccess;
	private int repNum;
	
	public MemberView(int id,String nickname,Date regDate,int dogNum,int mtReqNum, int mtRespNum, int mtSuccess, int repNum) {
		super(id, null, null, nickname, 0, null, null, regDate);
		this.dogNum = dogNum;
		this.mtReqNum = mtReqNum;
		this.mtRespNum = mtRespNum;
		this.mtSuccess = mtSuccess;
		this.repNum=repNum;
	}

	public MemberView() {
		// TODO Auto-generated constructor stub
	}

	public int getDogNum() {
		return dogNum;
	}

	public void setDogNum(int dogNum) {
		this.dogNum = dogNum;
	}

	public int getMtReqNum() {
		return mtReqNum;
	}

	public void setMtReqNum(int mtReqNum) {
		this.mtReqNum = mtReqNum;
	}

	public int getMtRespNum() {
		return mtRespNum;
	}

	public void setMtRespNum(int mtRespNum) {
		this.mtRespNum = mtRespNum;
	}

	public int getMtSuccess() {
		return mtSuccess;
	}

	public void setMtSuccess(int mtSuccess) {
		this.mtSuccess = mtSuccess;
	}

	public int getRepNum() {
		return repNum;
	}

	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}
	
	
	

}

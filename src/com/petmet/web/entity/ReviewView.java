package com.petmet.web.entity;

import java.util.Date;

public class ReviewView extends Review {

	private String memberName;
	private String categoryName;
	private int num;

	public ReviewView() {

	}

	public ReviewView(int id, int writerId, int petPlaceId, int rating, Date regDate, String content, String files,
			String memberName, String categoryName, int num) {
		super(id, writerId, petPlaceId, rating, regDate, content, files);
		this.memberName = memberName;
		this.categoryName = categoryName;
		this.num = num;
	}
	
	@Override
	public String toString() {
		
		return super.toString()+"ReviewView [memberName=" + memberName + ", categoryName=" + categoryName + ", num=" + num + "]";
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

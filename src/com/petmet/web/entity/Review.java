package com.petmet.web.entity;

import java.util.Date;

public class Review {
	private int id;
	private int writerId;
	private int petPlaceId;
	private int rating;
	private Date regDate;
	private String content;
	private String files;

	public Review() {
		this(0, 0, 0, 0, null, null, null);
	}

	public Review(int id, int writerId, int petPlaceId, int rating, Date regDate, String content, String files) {
		this.id = id;
		this.writerId = writerId;
		this.petPlaceId = petPlaceId;
		this.rating = rating;
		this.regDate = regDate;
		this.content = content;
		this.files = files;
	}
	
	//insert용
	public Review(int writerId, int petPlaceId, int rating, String content, String files) {
		this.writerId = writerId;
		this.petPlaceId = petPlaceId;
		this.rating = rating;
		this.content = content;
		this.files = files;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", writerId=" + writerId + ", petPlaceId=" + petPlaceId + ", rating=" + rating
				+ ", regDate=" + regDate + ", content=" + content + ", files=" + files + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public int getPetPlaceId() {
		return petPlaceId;
	}

	public void setPetPlaceId(int petPlaceId) {
		this.petPlaceId = petPlaceId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

}

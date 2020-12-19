package com.petmet.web.entity;

import java.util.Date;

public class PetPlaceView extends PetPlace {

	private int num;
	private int reviewCount;
	private double avgRating;
	private String writerName;
	private String categoryName;

	public PetPlaceView() {

	}

	public PetPlaceView(int id, int writerId, int categoryId, String name, String address, String homepage,
			String phone, String location, String content, Date regDate, String files, int hit, int likes, int pub,
			int num, int reviewCount, double avgRating, String writerName, String categoryName) {
		super(id, writerId, categoryId, name, address, homepage, phone, location, content, regDate, files, hit, likes,
				pub);

		this.num = num;
		this.reviewCount = reviewCount;
		this.avgRating = avgRating;
		this.writerName = writerName;
		this.categoryName = categoryName;
	}

	public PetPlaceView(int id, int writerId, int categoryId, String name, String address, String homepage,
			String phone, String location, String content, Date regDate, String files, int hit, int likes, int pub,
			int reviewCount, double avgRating, String writerName, String categoryName) {
		super(id, writerId, categoryId, name, address, homepage, phone, location, content, regDate, files, hit, likes,
				pub);

		this.reviewCount = reviewCount;
		this.avgRating = avgRating;
		this.writerName = writerName;
		this.categoryName = categoryName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}

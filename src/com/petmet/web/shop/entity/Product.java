package com.petmet.web.shop.entity;

public class Product {
	private int id;
	private int price;
	private int amount;
	private String posted;
	private String name;
	private String imgPath;
	private String regdate;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(int id, int price, int amount, String posted, String name, String imgPath, String regdate) {
		super();
		this.id = id;
		this.price = price;
		this.amount = amount;
		this.posted = posted;
		this.name = name;
		this.imgPath = imgPath;
		this.regdate = regdate;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPosted() {
		return posted;
	}
	public void setPosted(String posted) {
		this.posted = posted;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", amount=" + amount + ", posted=" + posted + ", name=" + name
				+ ", imgPath=" + imgPath + ", regdate=" + regdate + "]";
	}
}

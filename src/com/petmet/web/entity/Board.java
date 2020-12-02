package com.petmet.web.entity;

import java.util.Date;

public class Board {

	private int id;
	private int category;
	private String writer;
	private String title;
	private String content;
	private Date regdate;
	private int views;
	private String image;
	private int likes;

	public Board() {
		this(0, 0, null, null, null, null, 0, null, 0);
	}

	public Board(int id, int category, String writer, String title, String content, Date regdate, int views,
			String image, int likes) {
		this.id = id;
		this.category = category;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.views = views;
		this.image = image;
		this.likes = likes;
	}

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", category=" + category + ", writer=" + writer + ", title=" + title + ", content="
				+ content + ", regdate=" + regdate + ", views=" + views + ", image=" + image + ", likes=" + likes + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

}

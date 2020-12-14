package com.petmet.web.entity;

public class BoardCategoryView {
	private int id;
	private String name;
	private int cntBoard;
	
	public BoardCategoryView() {
		this(0, null, 0);
	}

	public BoardCategoryView(int id, String name, int cntBoard) {
		this.id = id;
		this.name = name;
		this.cntBoard = cntBoard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCntBoard() {
		return cntBoard;
	}

	public void setCntBoard(int cntBoard) {
		this.cntBoard = cntBoard;
	}

	@Override
	public String toString() {
		return "BoardCategoryView [id=" + id + ", name=" + name + ", cntBoard=" + cntBoard + "]";
	}
	
}

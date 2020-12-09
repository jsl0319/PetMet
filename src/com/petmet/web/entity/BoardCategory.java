package com.petmet.web.entity;

public class BoardCategory {
	private int id;
	private String name;
	
	public BoardCategory() {
		this(0,null);
	}

	public BoardCategory(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "BoardCategory [id=" + id + ", name=" + name + "]";
	}

}

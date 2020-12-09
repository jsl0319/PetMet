package com.petmet.web.entity;

public class PetplaceCategory {
	private int id;
	private String name;
	
	public PetplaceCategory() {
		this(0, null);
	}

	public PetplaceCategory(int id, String name) {
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
		return "PetplaceCategory [id=" + id + ", name=" + name + "]";
	}
	
}

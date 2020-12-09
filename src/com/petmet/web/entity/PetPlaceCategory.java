package com.petmet.web.entity;

public class PetPlaceCategory {
	
	private int id;
	private String name;
	
	public PetPlaceCategory() {
		
	}

	public PetPlaceCategory(int id, String name) {
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
		return "PetPlaceCategory [id=" + id + ", name=" + name + "]";
	}
	
}

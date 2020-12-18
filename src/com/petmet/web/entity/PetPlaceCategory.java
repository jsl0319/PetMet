package com.petmet.web.entity;

import java.util.Date;

public class PetPlaceCategory {
	private int id;
	private String name;
	private Date regDate;
	private Date editDate;

	public PetPlaceCategory() {
		this(0, null, null, null);
	}

	public PetPlaceCategory(int id, String name, Date regDate, Date editDate) {
		super();
		this.id = id;
		this.name = name;
		this.regDate = regDate;
		this.editDate = editDate;
	}

	@Override
	public String toString() {
		return "PetPlaceCategory [id=" + id + ", name=" + name + ", regDate=" + regDate + ", editDate=" + editDate
				+ "]";
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

}

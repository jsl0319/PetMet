package com.petmet.web.entity;

import java.util.Date;

public class PetPlaceCategoryView extends PetPlaceCategory {

	private int num;

	public PetPlaceCategoryView() {
		super();
	}

	public PetPlaceCategoryView(int id, String name, Date regDate, Date editDate, int num) {
		super(id, name, regDate, editDate);
		this.num = num;
	}

	@Override
	public String toString() {
		return "PetPlaceCategoryView [num=" + num + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

package com.petmet.web.entity;

import java.util.Date;

public class PetPlaceView extends PetPlace{
	
	private int num;
	
	public PetPlaceView() {
		
	}

	public PetPlaceView(int id, String writerId, String categoryId, String name, String address, String homepage,
			String phone, String location, String content, Date regDate, String files, int hit, int likes, int pub, int num) {
		super(id, writerId, categoryId, name, address, homepage, phone, location, content, regDate, files, hit, likes, pub);
		
		this.num = num;
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

package com.petmet.web.entity;

import java.util.Date;

public class Dog {
	 private int id;
	 private String name;
	 private String kind;
	 private int gender;
	 private int neut;
	 private Date birth;
	 private int weight;
	 private String content;
	 private String character;
	 private String files;
	 private String masterId;
	 private Date regDate;

	public Dog() {
		this(0,null,null,0,0,null,0,null,null,null,null,null);
	}

	public Dog(int id, String name, String kind, int gender, int neut, Date birth, int weight, String content,
			String character, String files, String masterId, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.gender = gender;
		this.neut = neut;
		this.birth = birth;
		this.weight = weight;
		this.content = content;
		this.character = character;
		this.files = files;
		this.masterId = masterId;
		this.regDate = regDate;
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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getNeut() {
		return neut;
	}

	public void setNeut(int neut) {
		this.neut = neut;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", kind=" + kind + ", gender=" + gender + ", neut=" + neut
				+ ", birth=" + birth + ", weight=" + weight + ", content=" + content + ", character=" + character
				+ ", files=" + files + ", masterId=" + masterId + ", regDate=" + regDate + "]";
	}
	
}

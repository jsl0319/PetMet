package com.petmet.web.entity;

public class Likes {
	private int id;
	private String memId;
	private int boardId;
	
	//---------------------------------- Constructor ----------------------------------
	public Likes() {
		this(0, null, 0);
	}

	public Likes(int id, String memId, int boardId) {
		this.id = id;
		this.memId = memId;
		this.boardId = boardId;
	}

	//---------------------------------- Getters/Setters ----------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	//---------------------------------- Functions ----------------------------------
	@Override
	public String toString() {
		return "Likes [id=" + id + ", memId=" + memId + ", boardId=" + boardId + "]";
	}
	
}

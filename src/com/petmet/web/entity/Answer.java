package com.petmet.web.entity;

import java.util.Date;

public class Answer {
	private int questionId;
    private String writerId;
    private String content;
    private Date regDate;
    
    public Answer() {
		this(0,null,null,null);
	}

	public Answer(int questionId, String writerId, String content, Date regDate) {
		this.questionId = questionId;
		this.writerId = writerId;
		this.content = content;
		this.regDate = regDate;
	}

	public Answer(int questionId, String writerId, String content) {
		this.questionId = questionId;
		this.writerId = writerId;
		this.content = content;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Answer [questionId=" + questionId + ", writerId=" + writerId + ", content=" + content + ", regDate="
				+ regDate + "]";
	}
}

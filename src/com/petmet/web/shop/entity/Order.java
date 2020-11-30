package com.petmet.web.shop.entity;

import java.util.Date;

public class Order {
	private int id;
    private String userId;
    private Date payDate;
    private String productName;
    private int payAmount;
    private String payMethod;
    private String payStatement;
    private String deliveryStatement;
    private String refund;
    
// -------------------------------------- Constructor --------------------------------------
    public Order() {
		this(0, null, null, null, 0, null, null, null, null);
	}
    
	public Order(int id, String userId, Date payDate, String productName, int payAmount, String payMethod,
			String payStatement, String deliveryStatement, String refund) {
		this.id = id;
		this.userId = userId;
		this.payDate = payDate;
		this.productName = productName;
		this.payAmount = payAmount;
		this.payMethod = payMethod;
		this.payStatement = payStatement;
		this.deliveryStatement = deliveryStatement;
		this.refund = refund;
	}
	
// -------------------------------------- Getters/Setters --------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getPayStatement() {
		return payStatement;
	}

	public void setPayStatement(String payStatement) {
		this.payStatement = payStatement;
	}

	public String getDeliveryStatement() {
		return deliveryStatement;
	}

	public void setDeliveryStatement(String deliveryStatement) {
		this.deliveryStatement = deliveryStatement;
	}

	public String getRefund() {
		return refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}
	
// -------------------------------------- Functions --------------------------------------
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", payDate=" + payDate + ", productName=" + productName
				+ ", payAmount=" + payAmount + ", payMethod=" + payMethod + ", payStatement=" + payStatement
				+ ", deliveryStatement=" + deliveryStatement + ", refund=" + refund + "]";
	}
	
}

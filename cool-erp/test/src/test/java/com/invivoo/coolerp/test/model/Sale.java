package com.invivoo.coolerp.test.model;

import java.util.Date;

public class Sale {
	private long id;
	private long productId;
	private Date date;
	private String status;
	
	public Sale(){
		
	}

	public Sale(long id, long productId, Date date, String status) {
		super();
		this.id = id;
		this.productId = productId;
		this.date = date;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

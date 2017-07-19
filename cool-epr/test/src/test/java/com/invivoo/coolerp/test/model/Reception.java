package com.invivoo.coolerp.test.model;

import java.util.Date;

public class Reception {
	private long id;
	private long purchaseOrderId;
	private long productId;
	private Date date;
	private String status;

	public Reception() {

	}

	public Reception(long id, long purchaseOrderId, long productId, Date date, String status) {
		this.id = id;
		this.purchaseOrderId = purchaseOrderId;
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

	public long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
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

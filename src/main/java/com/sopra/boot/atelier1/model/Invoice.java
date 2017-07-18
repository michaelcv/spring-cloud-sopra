package com.sopra.boot.atelier1.model;

import java.util.Date;

public class Invoice {
	private int id;
	private Date datetime;

	public Invoice(int id, Date datetime) {
		this.id = id;
		this.datetime = datetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}

package com.invivoo.coolerp.test.model;

public class Sort {
	private boolean sorted;
	private boolean unsorted;

	public Sort() {

	}

	public Sort(boolean sorted, boolean unsorted) {
		this.sorted = sorted;
		this.unsorted = unsorted;
	}

	public boolean isSorted() {
		return sorted;
	}

	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	public boolean isUnsorted() {
		return unsorted;
	}

	public void setUnsorted(boolean unsorted) {
		this.unsorted = unsorted;
	}
}

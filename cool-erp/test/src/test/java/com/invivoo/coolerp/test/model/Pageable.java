package com.invivoo.coolerp.test.model;

public class Pageable {
	private Sort sort;
	private int offset;
	private int pageSize;
	private int pageNumber;
	private boolean unpage;
	private boolean paged;

	public Pageable() {

	}

	public Pageable(Sort sort, int offset, int pageSize, int pageNumber, boolean unpage, boolean paged) {
		this.sort = sort;
		this.offset = offset;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.unpage = unpage;
		this.paged = paged;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public boolean isUnpage() {
		return unpage;
	}

	public void setUnpage(boolean unpage) {
		this.unpage = unpage;
	}

	public boolean isPaged() {
		return paged;
	}

	public void setPaged(boolean paged) {
		this.paged = paged;
	}
}

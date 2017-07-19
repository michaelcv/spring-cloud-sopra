package com.invivoo.coolerp.test.model;

import java.util.List;

public class Page<T> {
	private List<T> content;
	private Pageable pageable;
	private long totalPages;
	private boolean last;
	private long totalElements;
	private int size;
	private int number;
	private int numberOfElements;
	private Sort sort;
	private boolean first;

	public Page() {

	}

	public Page(List<T> content, Pageable pageable, long totalPages, boolean last, long totalElements, int size,
			int number, int numberOfElements, Sort sort, boolean first) {
		this.content = content;
		this.pageable = pageable;
		this.totalPages = totalPages;
		this.last = last;
		this.totalElements = totalElements;
		this.size = size;
		this.number = number;
		this.numberOfElements = numberOfElements;
		this.sort = sort;
		this.first = first;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
}

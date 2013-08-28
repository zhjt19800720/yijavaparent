package com.yijava.common.model;

import java.io.Serializable;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class PageInfo extends SqlSessionDaoSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7089027854531524300L;

	private int dataCount = 0;
	private int perPageSize = 0;
	protected int page = 1;
	private int startRecord = 0;
	private int endRecord = 0;
	private int pageCount = 0;
	private int previous = 0;
	private int next = 0;
	private boolean hasPrevious = false;
	private boolean hasNext = false;

	public void calculate() {
		if ((this.perPageSize < 1) || (this.dataCount < 0)) {
			return;
		}
		if (this.dataCount == 0)
			this.pageCount = 1;
		else {
			this.pageCount = (this.dataCount % this.perPageSize == 0 ? this.dataCount
					/ this.perPageSize
					: this.dataCount / this.perPageSize + 1);
		}
		this.page = (this.page < 1 ? 1 : this.page);
		this.page = (this.page > this.pageCount ? this.pageCount : this.page);

		this.startRecord = (this.perPageSize * (this.page - 1));
		this.startRecord = (this.startRecord > this.dataCount ? this.dataCount
				: this.startRecord);

		this.endRecord = (this.startRecord + this.perPageSize + 1);
		this.endRecord = (this.endRecord > this.dataCount ? this.dataCount + 1
				: this.endRecord);

		if (this.page > 1)
			this.hasPrevious = true;
		if (this.page < this.pageCount)
			this.hasNext = true;
	}
	
	public int getDataCount() {
	    return this.dataCount;
	  }

	  public void setDataCount(int dataCount) {
	    this.dataCount = dataCount;
	  }

	  public int getPerPageSize() {
	    return this.perPageSize;
	  }

	  public void setPerPageSize(int pageSize) {
	    this.perPageSize = pageSize;
	  }

	  public int getPage() {
	    return this.page;
	  }

	  public void setPage(int pageNow) {
	    this.page = pageNow;
	  }

	  public int getPageCount() {
	    return this.pageCount;
	  }

	  public void setPageCount(int pageCount) {
	    this.pageCount = pageCount;
	  }

	  public int getEndRecord() {
	    return this.endRecord;
	  }

	  public void setEndRecord(int dataEnd) {
	    this.endRecord = dataEnd;
	  }

	  public int getStartRecord() {
	    return this.startRecord;
	  }

	  public void setStartRecord(int dataStart) {
	    this.startRecord = dataStart;
	  }

	  public boolean isHasPrevious() {
	    return this.hasPrevious;
	  }

	  public boolean isHasNext() {
	    return this.hasNext;
	  }

	  public int getPrevious() {
	    if (this.page <= 1)
	      this.previous = 1;
	    else
	      this.previous = (this.page - 1);
	    return this.previous;
	  }

	  public int getNext() {
	    if (this.page >= this.pageCount)
	      this.next = this.pageCount;
	    else
	      this.next = (this.page + 1);
	    return this.next;
	  }
}

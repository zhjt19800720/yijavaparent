package com.yijava.orm.core;

import java.io.Serializable;
import java.util.List;

public class JsonPage<T>  implements Serializable {

	protected List<T> rows = null;
	protected long total = -1;
	
	
	
	public JsonPage() {
		super();
	}
	
	
	public JsonPage(List<T> rows, long total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
	
}

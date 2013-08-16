package com.yijava.web.vo;

import java.util.List;
import java.util.Map;

public class DownScribe {
	
	private List<DownScribeBody> subject_set;

	public List<DownScribeBody> getSubject_set() {
		return subject_set;
	}

	public void setSubject_set( List<DownScribeBody> subject_set) {
		this.subject_set = subject_set;
	}

	public DownScribe(List<DownScribeBody> subject_set) {
		super();
		this.subject_set = subject_set;
	}

	public DownScribe() {
		super();
	}
	
	 
}

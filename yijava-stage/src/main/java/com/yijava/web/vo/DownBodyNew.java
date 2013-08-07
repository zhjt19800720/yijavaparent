package com.yijava.web.vo;

import java.util.List;

public class DownBodyNew {

	private String timer;
	private List<CncNew> news_set;
	
	
	
	public DownBodyNew(String timer, List<CncNew> news_set) {
		super();
		this.timer = timer;
		this.news_set = news_set;
	}
	
	
	
	public DownBodyNew() {
		super();
	}



	public String getTimer() {
		return timer;
	}
	public void setTimer(String timer) {
		this.timer = timer;
	}
	public List<CncNew> getNews_set() {
		return news_set;
	}
	public void setNews_set(List<CncNew> news_set) {
		this.news_set = news_set;
	}
	
	
}

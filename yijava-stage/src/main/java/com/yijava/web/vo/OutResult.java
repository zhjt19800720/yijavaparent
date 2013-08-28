package com.yijava.web.vo;

public class OutResult <T>{

	private OutHeader head;
	
	private T body;
	
	
	
	
	
	

	public OutHeader getHead() {
		return head;
	}

	public void setHead(OutHeader head) {
		this.head = head;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
}

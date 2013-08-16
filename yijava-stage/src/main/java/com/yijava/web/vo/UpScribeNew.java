package com.yijava.web.vo;

public class UpScribeNew {

	private UpColumnHeader head;

	private UpScribeNewBody body;

	
	public UpScribeNew() {
		super();
	}


	public UpScribeNew(UpColumnHeader head, UpScribeNewBody body) {
		super();
		this.head = head;
		this.body = body;
	}


	public UpColumnHeader getHead() {
		return head;
	}


	public void setHead(UpColumnHeader head) {
		this.head = head;
	}


	public UpScribeNewBody getBody() {
		return body;
	}


	public void setBody(UpScribeNewBody body) {
		this.body = body;
	}

	
}

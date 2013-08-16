package com.yijava.web.vo;

public class UpScribe {

	private UpColumnHeader head;
	
	private UpScribeBody body;

	
	
	public UpScribe() {
		super();
	}

	public UpScribe(UpColumnHeader head, UpScribeBody body) {
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

	public UpScribeBody getBody() {
		return body;
	}

	public void setBody(UpScribeBody body) {
		this.body = body;
	}
	
	
}

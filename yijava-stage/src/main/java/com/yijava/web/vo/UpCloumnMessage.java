package com.yijava.web.vo;

public class UpCloumnMessage {

	private UpColumnHeader head;
	
	private UpColumnBody body;

	
	
	public UpCloumnMessage() {
		super();
	}

	public UpCloumnMessage(UpColumnHeader head, UpColumnBody body) {
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

	public UpColumnBody getBody() {
		return body;
	}

	public void setBody(UpColumnBody body) {
		this.body = body;
	}
	
	
	
}

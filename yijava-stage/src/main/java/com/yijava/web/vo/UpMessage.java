package com.yijava.web.vo;

public class UpMessage {

	private UpHeader head;
	
	private UpBody body;

	
	
	public UpMessage() {
		super();
	}

	public UpMessage(UpHeader head, UpBody body) {
		super();
		this.head = head;
		this.body = body;
	}

	public UpHeader getHead() {
		return head;
	}

	public void setHead(UpHeader head) {
		this.head = head;
	}

	public UpBody getBody() {
		return body;
	}

	public void setBody(UpBody body) {
		this.body = body;
	}
	
	
}

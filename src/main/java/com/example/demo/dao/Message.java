package com.example.demo.dao;

import org.springframework.http.HttpStatus;

public class Message {
	private String type;
	private String message;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Message(String string, String string2, HttpStatus ok) {
		super();
	}

	public Message(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}

}

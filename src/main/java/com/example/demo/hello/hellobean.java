package com.example.demo.hello;

public class hellobean {

	private String message;

	public hellobean(String message) {
		this.message=message;
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "hellobean [message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

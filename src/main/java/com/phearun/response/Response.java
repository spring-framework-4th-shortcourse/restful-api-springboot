package com.phearun.response;

public class Response {
	
	protected String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + "]";
	}
}

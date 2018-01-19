package com.phearun.response;

import java.util.List;

import com.phearun.model.User;

public class ResponseList extends Response{
	
	public ResponseList(String message) {
		super(message);
	}

	public ResponseList(String message, List<User> data) {
		super(message);
		this.data = data;
	}

	private List<User> data;

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseList [data=" + data + "]";
	}	
	
}

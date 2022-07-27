package com.techtree.Crud.response;

import java.util.Optional;

public class Response<T> {
	private String message;
	private T data;
	private Optional<T> opData;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	public void setOpData(Optional<T> opData) {
		this.opData = opData;
	}
	
	public Optional<T> getOpData() {
		return opData;
	}

	


}

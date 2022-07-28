package com.techtree.Crud.response;

import java.util.Optional;

public class Response <T> {
	private String message;
	private T data;
	private Optional<T> opdata;
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
	public Optional<T> getOpdata() {
		return opdata;
	}
	public void setOpData(Optional<T> opdata) {
		this.opdata = opdata;
	}

	
}

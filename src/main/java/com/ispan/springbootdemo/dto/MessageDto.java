package com.ispan.springbootdemo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("message")
	private String msg;
	
	public MessageDto() {}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}

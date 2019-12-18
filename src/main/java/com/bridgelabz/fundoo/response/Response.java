package com.bridgelabz.fundoo.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response implements Serializable {
	
	private int status;
	private String response;
	private Object object;
	public Response(int status, String response) {
		super();
		this.status = status;
		this.response = response;
	}
	public Response(int status, String response, Object object) {
		super();
		this.status = status;
		this.response = response;
		this.object = object;
	}
	
	
	
	

}

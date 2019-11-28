package com.bridgelabz.fundoo.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response implements Serializable {
	
	private int status;
	private String response;
	public Response(int status, String response) {
		super();
		this.status = status;
		this.response = response;
	}
	
	

}

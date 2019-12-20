package com.bridgelabz.fundoo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.common.net.HttpHeaders;

@RestController
public class WebClientController {

	private static final String BASE_URL = "http://localhost:8080";



	private WebClient webClient;

	public void init() {
		webClient = WebClient.builder().baseUrl(BASE_URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	

}

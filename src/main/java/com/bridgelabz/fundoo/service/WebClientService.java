package com.bridgelabz.fundoo.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientService {
	
	private static final String BASE_URL = "http://localhost:8080/";


	private  WebClient webClient ;
	
	@PostConstruct
	public void init() {
		webClient = WebClient.builder().baseUrl(BASE_URL).build();
	}
	
	public Long getUserId(String token) {
		return  webClient.get()
		         .uri("users/verify/"+token)
		         .retrieve().bodyToMono(Long.class).block();
		}
}

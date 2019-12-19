package com.bridgelabz.fundoo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTProvider {
	private final String secret = "Gautam";

	public String generateToken(String emailId) {
		return JWT.create().withClaim("email", emailId).sign(Algorithm.HMAC512(secret));
	}

	public String parseToken(String token) {
		return JWT.require(Algorithm.HMAC512(secret)).build().verify(token).getClaim("email").asString();
	}
	
}
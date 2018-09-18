package com.redhat.sbjwtdemo;

import java.util.Base64;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

	@RequestMapping("/token")
	public String token(@RequestHeader("Authorization") String authToken) {
		String jwsString = authToken.replaceFirst("Bearer ", "");
		String[] parts = jwsString.split("\\.");
		String output = "";
		for (int i = 0; i < parts.length - 1; i++) {
			byte[] decoded = Base64.getMimeDecoder().decode(parts[i]);
			output = new String(decoded);
			System.out.println(output);
		}
		return output;
	}
}

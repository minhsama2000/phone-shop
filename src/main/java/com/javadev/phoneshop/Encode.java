package com.javadev.phoneshop;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encode {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		String result = encoder.encode("minh");
		System.out.println(result);
	}
}

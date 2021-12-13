package com.javadev.phoneshop.utility;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.slugify.Slugify;

public class StringUtil {
	public static boolean isNullOrEmpty(String str) {
		return str == null || str.equals("");
	}

	public static String seo(String text) {
		return new Slugify().slugify(text);
	}

	public static String randomOrderCode() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		return random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

	}
}

package com.javadev.phoneshop.utility;

import com.github.slugify.Slugify;

public class StringUtil {
	public static boolean isNullOrEmpty(String str) {
		return str.isEmpty() || str.equals("");
	}
	public static String seo(String text) {
        return new Slugify().slugify(text);
    }
}

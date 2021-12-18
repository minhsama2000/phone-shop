package com.javadev.phoneshop.constant;

import java.io.File;

public class Constant {
	public static String ROOT_UPLOAD_PRODUCT = System.getProperty("user.dir") + File.separator +
			"upload" + File.separator + "product" + File.separator;
	public static String ROOT_UPLOAD_USER = System.getProperty("user.dir") + File.separator +
			"upload" + File.separator + "user" + File.separator;
	public static String ROOT_UPLOAD_BLOG = System.getProperty("user.dir") + File.separator +
			"upload" + File.separator + "blog" + File.separator;
}

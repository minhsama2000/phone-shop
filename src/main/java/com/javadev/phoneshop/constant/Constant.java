package com.javadev.phoneshop.constant;

import java.io.File;

public class Constant {
	public static String ROOT_UPLOAD_PRODUCT = System.getProperty("user.dir") + File.separator + "upload"
			+ File.separator + "product" + File.separator;
	public static String ROOT_UPLOAD_USER = System.getProperty("user.dir") + File.separator + "upload" + File.separator
			+ "user" + File.separator;
	public static String ROOT_UPLOAD_BLOG = System.getProperty("user.dir") + File.separator + "upload" + File.separator
			+ "blog" + File.separator;
	public static String URL_FIND_PRODUCT_TGDD = "https://www.thegioididong.com/tim-kiem?key=";
	public static String URL_FIND_PRODUCT_FPT = "https://fptshop.com.vn/tim-kiem/";
	public static String URL_FIND_PRODUCT_HOANGHA = "https://hoanghamobile.com/tim-kiem?kwd=";
	public static String URL_FIND_PRODUCT_CELLPHONE = "https://cellphones.com.vn/catalogsearch/result/?q=";

	public enum PaymentMethod {
		COD(1), MOMO(2);

		private final Integer type;

		PaymentMethod(Integer type) {
			this.type = type;
		}

		public static PaymentMethod getFromEnum(int type) {
			for (PaymentMethod index : values()) {
				if (index.type == type) {
					return index;
				}
			}
			return null;
		}

		public Integer getType() {
			return type;
		}
	}
}

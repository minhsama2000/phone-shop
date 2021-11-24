package com.javadev.phoneshop.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	public static String toStrDate(Date date) {
		return dateFormat.format(date);
	}
}

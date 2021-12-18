package com.javadev.phoneshop.utility;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static boolean isEmptyUploadFile(MultipartFile image) {
		return image == null || image.getOriginalFilename().isEmpty();
	}
}

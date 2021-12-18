package com.javadev.phoneshop.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class BlogModel extends BaseModel {
	private String thumbnail;
	private String details;
	private String shortDescription;
	private String avatar;
	private MultipartFile file;
}

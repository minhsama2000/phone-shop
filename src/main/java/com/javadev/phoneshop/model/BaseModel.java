package com.javadev.phoneshop.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class BaseModel {
	private Integer id;
	private Boolean status = Boolean.TRUE;
	private Integer updatedBy;
	private Integer createdBy;
	private Date updatedDate;
	private Date createdDate;
}

package com.javadev.phoneshop.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseDto {
	private Integer id;
	private Boolean status = Boolean.TRUE;
	private Integer updatedBy;
	private Integer createdBy;
	private Date updatedDate;
	private Date createdDate;
}

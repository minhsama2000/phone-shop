package com.javadev.phoneshop.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class DhProductModel extends BaseModel implements Serializable {
	private String name;
	private String detailDescription;
	private Long price;
	private Long available;
	private int color;
	private int storage;
	private String seo;
	private Integer categoryId;
	private MultipartFile file;

	@Override
	public String toString() {
		return "DhProductModel [name=" + name + ", detailDescription=" + detailDescription + ", price=" + price
				+ ", available=" + available + ", color=" + color + ", storage=" + storage + ", seo=" + seo
				+ ", categoryId=" + categoryId + ", file=" + file + ", getId()=" + getId() + "]";
	}

}

package com.javadev.phoneshop.entity;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import com.javadev.phoneshop.entity.productProperty.Promotion;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "dh_product")
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "category", "orderProducts" })
public class DhProduct extends BaseEntity implements java.io.Serializable {

	@Column(name = "name", length = 1000, nullable = false)
	private String name;

	@Column(name = "detail_description", columnDefinition = "LONGTEXT", nullable = false)
	private String detailDescription;

	@Column(name = "price", nullable = false)
	private Long price;
	
	@Column(name = "available", nullable = true)
	private Long available;
	
	@Column(name = "color", nullable = true)
	private int color;
	
	@Column(name = "avatar", nullable = false)
	private String avatar;
	
	@Column(name = "storage", nullable = true)
	private int storage;

	@Column(name = "seo", length = 1000, nullable = false)
	private String seo;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private DhCategory category;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		DhProduct dhProduct = (DhProduct) o;
		return Objects.equals(name, dhProduct.name) && Objects.equals(detailDescription, dhProduct.detailDescription)
				&& Objects.equals(price, dhProduct.price) && Objects.equals(seo, dhProduct.seo)
				&& Objects.equals(category, dhProduct.category);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), name, detailDescription, price, seo, category);
	}

	@Override
	public String toString() {
		return "DhProduct [name=" + name + ", detailDescription=" + detailDescription + ", price=" + price + ", seo="
				+ seo + ", category=" + category  + ", getId()=" + getId() + "]";
	}

}

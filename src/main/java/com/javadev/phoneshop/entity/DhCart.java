package com.javadev.phoneshop.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@Table(name = "dh_cart")
public class DhCart extends BaseEntity {

	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "name")
	private String name;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "price")
	private Long price;
	@Column(name = "color")
	private int color;
	@Column(name = "storage")
	private int storage;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		DhCart dhCart = (DhCart) o;
		return Objects.equals(productId, dhCart.productId) && Objects.equals(userId, dhCart.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), productId, userId);
	}
}

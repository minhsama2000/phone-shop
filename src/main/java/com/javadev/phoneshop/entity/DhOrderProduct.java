package com.javadev.phoneshop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Objects;

@Entity
@Setter
@Getter
@ToString
@Table(name = "dh_order_product")
public class DhOrderProduct extends BaseEntity implements java.io.Serializable {

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Long price;

	@Column(name = "order_id")
	private Integer orderId;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		DhOrderProduct that = (DhOrderProduct) o;
		return quantity == that.quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), quantity);
	}
}

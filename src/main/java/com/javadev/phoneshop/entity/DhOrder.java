package com.javadev.phoneshop.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "dh_order")
public class DhOrder extends BaseEntity implements java.io.Serializable {

	@Column(name = "code_name", nullable = false, length = 50)
	private String codeName;

	@Column(name = "customer_name", nullable = false, length = 50)
	private String customerName;

	@Column(name = "customer_email", nullable = false, length = 50)
	private String customerEmail;

	@Column(name = "customer_phone", nullable = false, length = 14)
	private String customerPhone;

	@Column(name = "customer_address", nullable = false, length = 200)
	private String customerAddress;

	@Column(name = "seo", nullable = true, length = 300)
	private String seo;
	
	@Column(name = "payment_method", nullable = false)
    private Integer paymentMethod;
	
	@Column(name = "order_status", nullable = false, columnDefinition = "1")
	private Integer orderStatus;

	@Column(name = "total", precision = 13, scale = 2)
	private Long total;
	
	@Column(name = "user_id",nullable = true)
	private Integer userId;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		DhOrder dhOrder = (DhOrder) o;
		return Objects.equals(codeName, dhOrder.codeName) && Objects.equals(customerName, dhOrder.customerName)
				&& Objects.equals(customerEmail, dhOrder.customerEmail)
				&& Objects.equals(customerPhone, dhOrder.customerPhone)
				&& Objects.equals(customerAddress, dhOrder.customerAddress) && Objects.equals(seo, dhOrder.seo)
				&& Objects.equals(total, dhOrder.total);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), codeName, customerName, customerEmail, customerPhone, customerAddress,
				seo, total);
	}
}

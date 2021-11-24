package com.javadev.phoneshop.entity.productProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javadev.phoneshop.entity.BaseEntity;
import com.javadev.phoneshop.entity.DhProduct;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Pd_promotion")
public class Promotion extends BaseEntity{

	private String[] listPromotion;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private DhProduct dhProduct;
	
}

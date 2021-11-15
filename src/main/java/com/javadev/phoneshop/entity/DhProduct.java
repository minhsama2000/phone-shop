package com.javadev.phoneshop.entity;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "dh_product")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({ "category", "orderProducts" })
public class DhProduct extends BaseEntity implements java.io.Serializable {

	@Column(name = "name", length = 1000, nullable = false)
	@JsonProperty(value = "name")
	@JsonAlias(value = "productName")
	private String name;

	@Column(name = "detail_description", columnDefinition = "LONGTEXT", nullable = false)
	@JsonProperty(value = "detailDescription")
	private String detailDescription;

	@Column(name = "short_description", length = 1000, nullable = false)
	@JsonProperty(value = "shortDescription")
	private String shortDescription;

	@Column(name = "price", nullable = false)
	private Long price;

	@Column(name = "seo", length = 1000, nullable = false)
	private String seo;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private DhCategory category;

	@OneToMany(mappedBy = "dhProduct", cascade = CascadeType.ALL)
	private List<DhOrderProduct> orderProducts = new ArrayList<>();

	public void addOrderProduct(DhOrderProduct orderProduct) {
		this.orderProducts.add(orderProduct);
		orderProduct.setDhProduct(this);
	}

	public void removeOrderProduct(DhOrderProduct orderProduct) {
		this.orderProducts.remove(orderProduct);
		orderProduct.setDhProduct(null);
	}

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
				&& Objects.equals(shortDescription, dhProduct.shortDescription)
				&& Objects.equals(price, dhProduct.price) && Objects.equals(seo, dhProduct.seo)
				&& Objects.equals(category, dhProduct.category)
				&& Objects.equals(orderProducts, dhProduct.orderProducts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), name, detailDescription, shortDescription, price, seo,
				category, orderProducts);
	}

	@Override
	public String toString() {
		return "DhProduct [name=" + name + ", detailDescription=" + detailDescription + ", shortDescription="
				+ shortDescription + ", price=" + price + ", seo=" + seo + ", category="
				+ category + ", orderProducts=" + orderProducts + ", getId()=" + getId() + "]";
	}

}

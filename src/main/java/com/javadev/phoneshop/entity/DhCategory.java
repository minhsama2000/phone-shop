package com.javadev.phoneshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "dh_category")
public class DhCategory extends BaseEntity implements java.io.Serializable {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "seo", nullable = false)
    private String seo;

    @Column(name = "parent_id", nullable = true)
    @JsonProperty(value = "parent_id")
    private Integer parentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DhCategory category = (DhCategory) o;
        return Objects.equals(name, category.name) 
        		&& Objects.equals(seo, category.seo) 
        		&& Objects.equals(parentId, category.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, seo, parentId);
    }

	@Override
	public String toString() {
		return "DhCategory [name=" + name + ", seo=" + seo + ", parentId=" + parentId + ", getId()=" + getId() + "]";
	}
    
    
}

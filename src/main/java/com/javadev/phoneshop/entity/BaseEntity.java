package com.javadev.phoneshop.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@MappedSuperclass
@Data
@ToString
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "status", nullable = true)
	private Boolean status = Boolean.TRUE;

	@Column(name = "updated_by", nullable = true)
	private Integer updatedBy;

	@Column(name = "created_by", nullable = true)
	private Integer createdBy;

	@Column(name = "updated_date", nullable = true)
	private Date updatedDate;

	@Column(name = "created_date", nullable = true)
	private Date createdDate;

	@Transient
	private Map<String, Object> map = new HashMap<>();

	@JsonAnyGetter
	public Map<String, Object> getMap() {
		return map;
	}

	@JsonAnySetter
	public void setMap(String key, Object value) {
		map.put(key, value);
	}

}

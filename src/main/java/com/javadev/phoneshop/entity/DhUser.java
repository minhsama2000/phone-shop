package com.javadev.phoneshop.entity;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Entity
@Table(name = "dh_user")
@Setter
@Getter
@ToString
public class DhUser extends BaseEntity implements java.io.Serializable {

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@Column(name = "password", nullable = false, length = 100)
	private String password;

	@Column(name = "username", nullable = false, length = 50)
	@JsonProperty(value = "username")
	private String username;

	@Column(name = "avatar", nullable = true, length = 1000)
	@JsonProperty(value = "avatar")
	private String avatar;

	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "address", nullable = true, columnDefinition = "LONGTEXT")
	private String address;
	
	@Column(name = "phone", nullable = true, length=15)
	private String phone;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "dh_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	@JsonProperty(value = "roles")
	private Set<DhRole> dhRoles = new HashSet<>();

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		DhUser dhUser = (DhUser) o;
		return Objects.equals(email, dhUser.email) && Objects.equals(password, dhUser.password)
				&& Objects.equals(username, dhUser.username) && Objects.equals(dhRoles, dhUser.dhRoles)
				&& Objects.equals(avatar, dhUser.avatar);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), email, password, username, dhRoles,avatar);
	}
}

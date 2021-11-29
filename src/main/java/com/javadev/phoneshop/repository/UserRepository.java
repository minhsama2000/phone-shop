package com.javadev.phoneshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.phoneshop.entity.DhUser;

public interface UserRepository extends JpaRepository<DhUser, Integer> {
	 Optional<DhUser> findByUsername(String userName);
}

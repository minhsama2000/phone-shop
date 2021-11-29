package com.javadev.phoneshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.phoneshop.entity.DhRole;

public interface RoleRepository extends JpaRepository<DhRole, Integer>{

	Optional<DhRole> findByName(String name);
}

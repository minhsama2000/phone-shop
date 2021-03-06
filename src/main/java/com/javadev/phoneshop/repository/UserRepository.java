package com.javadev.phoneshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javadev.phoneshop.entity.DhUser;

public interface UserRepository extends JpaRepository<DhUser, Integer> {
	 Optional<DhUser> findByUsername(String userName);
	 Optional<DhUser> findByEmail(String email);
	 
	 @Query(value = "SELECT * FROM dh_user where username = ?1",nativeQuery = true)
	 DhUser getByUsername(String userName);
}

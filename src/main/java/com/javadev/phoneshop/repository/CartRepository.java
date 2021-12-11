package com.javadev.phoneshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javadev.phoneshop.entity.DhCart;

public interface CartRepository extends JpaRepository<DhCart, Integer>{

	Optional<DhCart> findByUserIdAndProductIdAndStorageAndColor(Integer userId, Integer productId,int storage, int color);
	
	@Query(value = "SELECT * FROM dh_cart where user_id = :userId",nativeQuery = true)
	List<DhCart> findAllByUserId(@Param("userId") Integer userId);
}

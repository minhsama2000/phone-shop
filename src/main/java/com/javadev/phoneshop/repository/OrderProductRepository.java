package com.javadev.phoneshop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javadev.phoneshop.entity.DhOrderProduct;

public interface OrderProductRepository extends JpaRepository<DhOrderProduct, Integer> {

	@Query(value = "delete from dh_order_product where order_id = :orderId",nativeQuery = true)
	@Transactional
	@Modifying
	void deleteByOrderId(@Param("orderId") Integer orderId);
	
	@Query(value = "select * from dh_order_product where order_id = :orderId",nativeQuery = true)
    List<DhOrderProduct> findByOrderId(@Param("orderId") Integer orderId);
}

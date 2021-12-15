package com.javadev.phoneshop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javadev.phoneshop.entity.DhOrderProduct;

public interface OrderProductRepository extends JpaRepository<DhOrderProduct, Integer> {

	@Query(value = "delete from DhOrderProduct where order.id = :orderId")
	@Transactional
	@Modifying
	void deleteByOrderId(@Param("orderId") Integer orderId);
	
	@Query(value = "from DhOrderProduct where order.id = :orderId")
    List<DhOrderProduct> findByOrderId(@Param("orderId") Integer orderId);
}

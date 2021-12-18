package com.javadev.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javadev.phoneshop.entity.DhOrder;

public interface OrderRepository extends JpaRepository<DhOrder, Integer>{
	
	@Query(value = "select * from dh_order where order_status = :orderStatus", nativeQuery = true)
    List<DhOrder> findByOrderStatus(@Param("orderStatus") Integer orderStatus);
	
    @Query(value = "select * from dh_order where user_id = :userId", nativeQuery = true)
    List<DhOrder> findByUserId(@Param("userId") Integer userId);
	
    @Query(value = "SELECT SUM(total) FROM dh_order where order_status = :status", nativeQuery = true)
    Long totalEarn(@Param("status") int status);
}	

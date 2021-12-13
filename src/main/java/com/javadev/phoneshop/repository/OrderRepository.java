package com.javadev.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.phoneshop.entity.DhOrder;

public interface OrderRepository extends JpaRepository<DhOrder, Integer>{

}

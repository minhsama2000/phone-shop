package com.javadev.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.phoneshop.entity.DhOrderProduct;

public interface OrderProductRepository extends JpaRepository<DhOrderProduct, Integer>{

}

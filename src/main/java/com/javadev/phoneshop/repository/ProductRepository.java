package com.javadev.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javadev.phoneshop.entity.DhProduct;

@Repository
public interface ProductRepository extends JpaRepository<DhProduct, Integer>{

}

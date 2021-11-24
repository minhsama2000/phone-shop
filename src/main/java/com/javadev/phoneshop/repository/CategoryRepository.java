package com.javadev.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javadev.phoneshop.entity.DhCategory;

@Repository
public interface CategoryRepository extends JpaRepository<DhCategory, Integer>{

}

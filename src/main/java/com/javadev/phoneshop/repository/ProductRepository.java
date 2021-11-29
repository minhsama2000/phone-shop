package com.javadev.phoneshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javadev.phoneshop.entity.DhProduct;

@Repository
public interface ProductRepository extends JpaRepository<DhProduct, Integer>,CustomProductRepository{

	@Query(value = "SELECT * FROM dh_product ORDER BY id DESC LIMIT ?1", nativeQuery = true)
	List<DhProduct> findByNew(int limit);

	@Query(value = "SELECT * FROM dh_product ORDER BY RAND() LIMIT ?1",nativeQuery = true)
	List<DhProduct> findByRandom(int limit);
	
	@Query(value = "SELECT * FROM dh_product where category_id = ?1 LIMIT ?2",nativeQuery = true)
	List<DhProduct> findAllById(Integer id,int limit);
	
	Page<DhProduct> findAll(Pageable pageable);

}

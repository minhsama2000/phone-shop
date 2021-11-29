package com.javadev.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javadev.phoneshop.entity.DhCategory;

@Repository
public interface CategoryRepository extends JpaRepository<DhCategory, Integer>{

	@Query(value = "select * from dh_category where parent_id = ?1",nativeQuery = true)
	List<DhCategory> getChildById(Integer id);
	
	@Query(value = "select id from dh_category where parent_id = ?1",nativeQuery = true)
	List<Integer> getListChildId(Integer id);
}

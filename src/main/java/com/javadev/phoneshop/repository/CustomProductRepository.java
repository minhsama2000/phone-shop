package com.javadev.phoneshop.repository;

import java.util.List;

import com.javadev.phoneshop.entity.DhProduct;

public interface CustomProductRepository {
	List<DhProduct> findByCategoryIdWithPage(int page, int size, Integer categoryId);

	List<DhProduct> findByCategoryId(Integer categoryId);

	List<DhProduct> findByCategoryIdChild(Integer categoryId);

	List<DhProduct> findByCategoryIdChildWithPage(int page, int size, Integer categoryId);

	List<DhProduct> findBySearchTextWithPage(int page, int size, String searchText);

	List<DhProduct> findBySearchText(String searchText);

	List<DhProduct> findTopAsc(int limitTop);
}

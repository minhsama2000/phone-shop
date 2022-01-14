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

	List<DhProduct> findByRandom(int limitTop);

	List<DhProduct> findByPriceSpace(int page, int size, Long start, Long end);

	List<DhProduct> findByStorage(int page, int size, int storage);

	List<DhProduct> findPriceDesc(int page, int size);

	List<DhProduct> findPriceAsc(int page, int size);
}

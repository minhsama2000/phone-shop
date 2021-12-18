package com.javadev.phoneshop.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.repository.CategoryRepository;
import com.javadev.phoneshop.repository.CustomProductRepository;

@Transactional(propagation = Propagation.NESTED)
public class CustomProductRepositoryImpl implements CustomProductRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<DhProduct> findTopAsc(int limitTop){
		String sql = "SELECT * FROM dh_product ORDER BY id ASC";
		List<DhProduct> dhProducts = null;
		Query query = entityManager.createNativeQuery(sql, DhProduct.class);
		dhProducts = query.setMaxResults(limitTop).getResultList();
		return dhProducts;
	}
	
	@Override
	public List<DhProduct> findByRandom(int limitTop){
		String sql = "SELECT * FROM dh_product ORDER BY RAND()";
		List<DhProduct> dhProducts = null;
		Query query = entityManager.createNativeQuery(sql, DhProduct.class);
		dhProducts = query.setMaxResults(limitTop).getResultList();
		return dhProducts;
	}
	
	@Override
	public List<DhProduct> findByCategoryIdWithPage(int page, int size, Integer categoryId) {
		String sql = "select r.* from ( select r.*, ROW_NUMBER() over(PARTITION BY r.category_id) " + 
				"rn from dh_product r ) r where r.category_id in (:inIdList)";
		List<DhProduct> dhProducts = null;
		Query query = entityManager.createNativeQuery(sql, DhProduct.class);
		query.setParameter("inIdList", categoryRepository.getListChildId(categoryId));
		dhProducts = query.setFirstResult(page).setMaxResults(size).getResultList();
		return dhProducts;
	}

	@Override
	public List<DhProduct> findByCategoryId(Integer categoryId) {
		String sql = "select r.* from ( select r.*, ROW_NUMBER() over(PARTITION BY r.category_id)" + 
				" rn from dh_product r ) r where r.category_id in (:inIdList)";
		List<DhProduct> dhProducts = null;
		Query query = entityManager.createNativeQuery(sql, DhProduct.class);
		query.setParameter("inIdList", categoryRepository.getListChildId(categoryId));
		dhProducts = query.getResultList();
		return dhProducts;
	}
	
	@Override
	public List<DhProduct> findBySearchTextWithPage(int page, int size, String searchText) {
		String jpql = "select p from DhProduct p where p.name like :name";
		List<DhProduct> dhProducts = null;
		Query query = entityManager.createQuery(jpql, DhProduct.class);
		query.setParameter("name", "%" + searchText + "%");
		dhProducts = query.setFirstResult(page).setMaxResults(size).getResultList();
		return dhProducts;
	}
	
	@Override
	public List<DhProduct> findBySearchText(String searchText) {
		String jpql = "select p from DhProduct p where p.name like :name";
		List<DhProduct> dhProducts = null;
		Query query = entityManager.createQuery(jpql, DhProduct.class);
		query.setParameter("name", "%" + searchText + "%");
		dhProducts = query.getResultList();
		return dhProducts;
	}
	
	@Override
	public List<DhProduct> findByCategoryIdChildWithPage(int page, int size, Integer categoryId) {
		String sql = "select * from dh_product where category_id = :categoryId";
		List<DhProduct> dhProducts = null;
		Query query = entityManager.createNativeQuery(sql, DhProduct.class);
		query.setParameter("categoryId", categoryId);
		dhProducts = query.setFirstResult(page).setMaxResults(size).getResultList();
		return dhProducts;
	}

	@Override
	public List<DhProduct> findByCategoryIdChild(Integer categoryId) {
		String sql = "select * from dh_product where category_id = :categoryId";
		List<DhProduct> dhProducts = null;
		Query query = entityManager.createNativeQuery(sql, DhProduct.class);
		query.setParameter("categoryId", categoryId);
		dhProducts = query.getResultList();
		return dhProducts;
	}
	
	
}

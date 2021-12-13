package com.javadev.phoneshop.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javadev.phoneshop.entity.DhCart;
import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.repository.CustomCartRepository;

@Transactional(propagation = Propagation.NESTED)
public class CustomCartRepositoryImpl implements CustomCartRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void deleteAllCartByUserId(Integer userId) {
		String sql = "DELETE FROM dh_cart where user_id = :userId";
		Query query = entityManager.createNativeQuery(sql, DhCart.class);
		query.setParameter("userId", userId);
		query.executeUpdate();
	}
}

package com.javadev.phoneshop.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javadev.phoneshop.entity.DhBlog;
import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.repository.CustomBlogRepository;

@Transactional(propagation = Propagation.NESTED)
public class CustomBlogRepositoryImpl implements CustomBlogRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<DhBlog> findTopAsc(int limitTop){
		String sql = "SELECT * FROM dh_blog ORDER BY id ASC";
		List<DhBlog> dhBlogs = null;
		Query query = entityManager.createNativeQuery(sql, DhBlog.class);
		dhBlogs = query.setMaxResults(limitTop).getResultList();
		return dhBlogs;
	}
}

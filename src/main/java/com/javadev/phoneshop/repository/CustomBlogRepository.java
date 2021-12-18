package com.javadev.phoneshop.repository;

import java.util.List;

import com.javadev.phoneshop.entity.DhBlog;
import com.javadev.phoneshop.entity.DhProduct;

public interface CustomBlogRepository {
	List<DhBlog> findTopAsc(int limitTop);
}

package com.javadev.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.phoneshop.entity.DhBlog;

public interface BlogRepository extends JpaRepository<DhBlog, Integer>,CustomBlogRepository{

}

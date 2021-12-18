package com.javadev.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadev.phoneshop.entity.DhContact;

public interface ContactRepository extends JpaRepository<DhContact, Integer>{

}

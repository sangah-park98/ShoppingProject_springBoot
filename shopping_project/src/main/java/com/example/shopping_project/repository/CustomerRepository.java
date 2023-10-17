package com.example.shopping_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopping_project.entity.Customer;

// <entity 클래스명, 기본키의 타입> 적어주기
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	
}

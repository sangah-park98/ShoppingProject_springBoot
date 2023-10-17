package com.example.shopping_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping_project.dto.CustomerForm;
import com.example.shopping_project.entity.Customer;
import com.example.shopping_project.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public void joinMember(CustomerForm form) {
		// entity로 바꾸기
		Customer customer = Customer.toEntity(form);
		customerRepository.save(customer);
	};
	
	
}

package com.example.shopping_project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.shopping_project.dto.CustomerForm;
import com.example.shopping_project.entity.Customer;
import com.example.shopping_project.repository.CustomerRepository;
import com.example.shopping_project.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
//	controller -> service -> repository
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/main") // 요청 시엔 GetMapping을 쓴다. (Post, delete 등 다양)
	public String mainViewPage(Model model) {
		return "main";
	}
	
	@GetMapping("/main/join")
	public String customerRegister(CustomerForm form) {
      log.info("MainController의 join() 메소드 실행");
      
      // Customer customer = form.toEntity();
      // Customer saved = customerRepository.save(customer);
      // log.info("saved: " + saved.toString());
      
      // return "redirect:/main/register" + saved.getCustomer_id();
      return "join";
   }

	@PostMapping("/main/joinMember")
	public String joinMember(CustomerForm form) {
		log.info("MainController의 joinMember() 메소드 실행");
		log.info("customerForm: " + form);
		// Customer customerEntity = customerRepository.findById(id).orElse(null);
		// model.addAttribute("customer", customerEntity);
		customerService.joinMember(form);
		 return "main";
	}
}






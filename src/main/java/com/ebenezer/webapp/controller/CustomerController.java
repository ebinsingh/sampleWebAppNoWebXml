package com.ebenezer.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.ebenezer.webapp.domain.Customer;
import com.ebenezer.webapp.engine.CustomerEngine;

@Controller
public class CustomerController {
	
	private CustomerEngine customerEngine;

	@Autowired
	public CustomerController(CustomerEngine customerEngine) {
		this.customerEngine = customerEngine;
	}

	public String greetCustomer(@RequestBody Customer customer){
		return customerEngine.generateGreeting(customer);
	}
}

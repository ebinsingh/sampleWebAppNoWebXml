package com.ebenezer.webapp.engine;

import org.springframework.stereotype.Service;

import com.ebenezer.webapp.domain.Customer;
import com.ebenezer.webapp.helper.EngineResponse;
import com.ebenezer.webapp.helper.JavaEngine;

@Service
public class DefaultCustomerEngine implements CustomerEngine {
	private JavaEngine engine;
	public String generateGreeting(Customer customer) {
		EngineResponse response = new EngineResponse();

		engine.run(customer, response); 

		String result = response.get("greeting") + ", " +
				response.get("salutation") + " " +
				customer.getCustomerName() + "!";
		System.out.println("Generated Greeting: " + result);
		return result;
	}
}

package com.ebenezer.webapp.helper;

import java.util.Calendar;

import com.ebenezer.webapp.domain.Customer;

public class JavaEngine {
	public void run(Customer customer, EngineResponse response) {
		defineGreeting(customer, response);
		defineSalutation(customer, response);
	}

	public void defineGreeting(Customer customer, EngineResponse response) {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

		String greeting = "?";
		if (hour > 0 && hour <= 12)
			greeting = "Good Morning";
		else if (hour > 12 && hour <= 18)
			greeting = "Good Afternoon";
		else if (hour > 18 && hour <= 21)
			greeting = "Good Evening";
		else if (hour > 21 && hour <= 24)
			greeting = "Good Night";
		response.put("greeting", greeting);
	}

	public void defineSalutation(Customer customer, EngineResponse response) {
		String salutation;
		if (customer.getGender().equals("Male")) {
			if (customer.getAge() < 4)
				salutation = "Little";
			else
				salutation = "Mr.";
		} else {
			if (customer.getMaritalStatus().equals("Married"))
				salutation = "Mrs.";
			else
				salutation = "Ms.";
		}
		response.put("salutation", salutation);
	}

}

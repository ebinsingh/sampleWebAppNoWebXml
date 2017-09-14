package com.ebenezer.webapp.services;

import com.ebenezer.webapp.domain.SalesReport;

public class SalesReportBuilder {
	private String productName;
	private double price;
	
	public SalesReportBuilder productName(String productName) {
		this.productName = productName;
		return this;
	}
	public SalesReportBuilder price(double price) {
		this.price = price;
		return this;
	}
	
	public SalesReport build(){
		SalesReport salesReport = new SalesReport();
		salesReport.setPrice(price);
		salesReport.setProductName(productName);
		
		return salesReport;
	}
	public static SalesReportBuilder withValidValues() {
		return new SalesReportBuilder()
		.price(100)
		.productName("Thomas Tank");
	}
	
}

package com.ebenezer.webapp.controller;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import com.ebenezer.webapp.client.MySampleWebAppClient;
import com.ebenezer.webapp.domain.SalesReport;
import com.ebenezer.webapp.operations.MySampleWebAppOperations;
import com.ebenezer.webapp.services.SalesReportBuilder;

public class MySampleWebAppClientIT {

	@Test
	public void shouldCreateAndPersistSalesRecord() throws Exception{
		SalesReport salesReport = SalesReportBuilder.withValidValues().build();
		MySampleWebAppOperations mySampleWebAppClient = new MySampleWebAppClient();
		SalesReport persistedDaSalesReport = mySampleWebAppClient.createSalesReport(salesReport);
		
		MatcherAssert.assertThat(persistedDaSalesReport.getId(), CoreMatchers.not(0L));
	}
}

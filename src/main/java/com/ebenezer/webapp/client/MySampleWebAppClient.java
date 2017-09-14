package com.ebenezer.webapp.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ebenezer.webapp.controller.ControllerPaths;
import com.ebenezer.webapp.domain.SalesReport;
import com.ebenezer.webapp.operations.MySampleWebAppOperations;

public class MySampleWebAppClient implements MySampleWebAppOperations{

	public SalesReport createSalesReport(SalesReport salesReport) throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/mySampleWebAppNoWebXml/")
				.path(ControllerPaths.CREATE_SALES_REPORT);
		Response response = target.request()
				.post(Entity.entity(salesReport, MediaType.APPLICATION_JSON_TYPE));
		return (SalesReport) response.getEntity();
	}

}

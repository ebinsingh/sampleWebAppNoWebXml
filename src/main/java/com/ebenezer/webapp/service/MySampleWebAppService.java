package com.ebenezer.webapp.service;

import com.ebenezer.webapp.domain.Course;
import com.ebenezer.webapp.domain.SalesReport;

public interface MySampleWebAppService {

	SalesReport createSalesReport(SalesReport salesReport);

	Course createCourse(Course course);

}

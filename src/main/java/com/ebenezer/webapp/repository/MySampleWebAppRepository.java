package com.ebenezer.webapp.repository;

import com.ebenezer.webapp.domain.Course;
import com.ebenezer.webapp.domain.SalesReport;

public interface MySampleWebAppRepository {

	SalesReport createSalesReport(SalesReport salesReport);

	Course createCourse(Course course);

}

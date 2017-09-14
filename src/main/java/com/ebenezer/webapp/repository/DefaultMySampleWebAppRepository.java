package com.ebenezer.webapp.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ebenezer.webapp.domain.Course;
import com.ebenezer.webapp.domain.SalesReport;

@Repository
public class DefaultMySampleWebAppRepository implements MySampleWebAppRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public SalesReport createSalesReport(SalesReport salesReport) {
		entityManager.persist(salesReport);
		List<String> l1 = new ArrayList<String>();
		return salesReport;
	}

	@Override
	public Course createCourse(Course course) {
		entityManager.persist(course);
		return course;
	}

}

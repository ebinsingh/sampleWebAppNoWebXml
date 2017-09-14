package com.ebenezer.webapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebenezer.webapp.domain.Course;
import com.ebenezer.webapp.domain.SalesReport;
import com.ebenezer.webapp.repository.MySampleWebAppRepository;

@Service
public class DefaultMySampleWebAppService implements MySampleWebAppService {

	private MySampleWebAppRepository mySampleWebAppRepository;
	
	@Autowired
	public DefaultMySampleWebAppService(MySampleWebAppRepository mySampleWebAppRepository) {
		this.mySampleWebAppRepository = mySampleWebAppRepository;
	}

	@Transactional
	public SalesReport createSalesReport(SalesReport salesReport) {
		return mySampleWebAppRepository.createSalesReport(salesReport);
	}

	@Transactional
	public Course createCourse(Course course) {
		return mySampleWebAppRepository.createCourse(course);
	}

}

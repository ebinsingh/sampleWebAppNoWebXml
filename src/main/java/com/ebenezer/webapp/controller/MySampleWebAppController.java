package com.ebenezer.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebenezer.webapp.domain.Course;
import com.ebenezer.webapp.domain.SalesReport;
import com.ebenezer.webapp.operations.MySampleWebAppOperations;
import com.ebenezer.webapp.service.MySampleWebAppService;

@RestController
public class MySampleWebAppController implements MySampleWebAppOperations{
	MySampleWebAppService mySampleWebAppService;
	
	@Autowired
	public MySampleWebAppController(MySampleWebAppService mySampleWebAppService) {
		this.mySampleWebAppService = mySampleWebAppService;
	}
	
	@RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
	public String getHomePage(ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value = "/"+ControllerPaths.CREATE_SALES_REPORT, method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SalesReport createSalesReport(@RequestBody SalesReport salesReport){
		return mySampleWebAppService.createSalesReport(salesReport);
	}
	
	@RequestMapping(value = "/"+ControllerPaths.CREATE_COURSE, method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Course createArticle(@RequestBody Course course) {
		System.out.println(course);
		Course created = mySampleWebAppService.createCourse(course);
		return created;
	}
	
	@RequestMapping(value = "/"+ControllerPaths.GET_ALL_COURSE, method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Course> getAllCourses(){
		return null;
		
	}

}

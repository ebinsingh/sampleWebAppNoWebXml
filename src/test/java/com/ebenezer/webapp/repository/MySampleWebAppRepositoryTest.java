package com.ebenezer.webapp.repository;

import javax.transaction.Transactional;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ebenezer.webapp.config.DataSourceConfig;
import com.ebenezer.webapp.domain.SalesReport;
import com.ebenezer.webapp.services.SalesReportBuilder;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ComponentScan("com.ebenezer.webapp")
public class MySampleWebAppRepositoryTest {
	@Autowired
	MySampleWebAppRepository mySampleWebAppRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void shouldCreateAndPersistSalesRecord(){
		SalesReport salesReport = SalesReportBuilder.withValidValues().build();
		//When
		SalesReport persistedSalesReport = mySampleWebAppRepository.createSalesReport(salesReport);
		
		//Then
		MatcherAssert.assertThat(persistedSalesReport.getId(), CoreMatchers.not(0L));
	}
	
	@Configuration
	@Import({DataSourceConfig.class})
	static class ContextConfiguration {
		@Bean
		public MySampleWebAppRepository mySampleWebAppRepository(){
			return new DefaultMySampleWebAppRepository();
		}
	}
}

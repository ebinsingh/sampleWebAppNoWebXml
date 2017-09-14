package com.ebenezer.webapp.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ebenezer.webapp.config.PropertyConfig;
import com.ebenezer.webapp.config.PropertySourceConfig;
import com.ebenezer.webapp.domain.SalesReport;
import com.ebenezer.webapp.repository.MySampleWebAppRepository;
import com.ebenezer.webapp.service.DefaultMySampleWebAppService;
import com.ebenezer.webapp.service.MySampleWebAppService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MySampleWebAppServiceTest {
	@Autowired
	MySampleWebAppService mySampleWebAppService;
	
	@Autowired
	MySampleWebAppRepository mySampleWebAppRepository;
	
	@Test
	public void shouldCreateAndPersistSalesRecord(){
		SalesReport salesReport = SalesReportBuilder.withValidValues().build();
		
		//When
		mySampleWebAppService.createSalesReport(salesReport);
		
		//Then
		Mockito.verify(mySampleWebAppRepository, Mockito.times(1)).createSalesReport(salesReport);
	}
	@Configuration
	@Import({PropertyConfig.class, PropertySourceConfig.class})
	static class ContextConfiguration {
		
		@Bean
		@Autowired
		public MySampleWebAppService mySampleWebAppService(MySampleWebAppRepository mySampleWebAppRepository){
			return new DefaultMySampleWebAppService(mySampleWebAppRepository);
		}
		
		@Bean
		public MySampleWebAppRepository mySampleWebAppRepository(){
			return Mockito.mock(MySampleWebAppRepository.class);
		}
	}
}

package com.ebenezer.webapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.StringWriter;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ebenezer.webapp.config.ApplicationConfig;
import com.ebenezer.webapp.domain.SalesReport;
import com.ebenezer.webapp.repository.MySampleWebAppRepository;
import com.ebenezer.webapp.service.MySampleWebAppService;
import com.ebenezer.webapp.services.SalesReportBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class MySampleWebAppControllerTest {
	@Autowired
	MySampleWebAppController mySampleWebAppController;
	
	@Autowired
	MySampleWebAppService mySampleWebAppService;
	
	@Autowired
	MySampleWebAppRepository mySampleWebAppRepository;
	
	private MockMvc mockMvc;
	private ObjectMapper mapper = new ObjectMapper();
	private StringWriter stringWriter = new StringWriter();
	private MediaType mediaType = new MediaType("Application", "json", Charset.forName("UTF-8"));

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(mySampleWebAppController).build();
	}

	@Test
	public void shouldCreateAndPersistSalesRecord() throws Exception {
		SalesReport salesReport = SalesReportBuilder.withValidValues().build();
		mapper.writeValue(stringWriter, salesReport);
		
		mockMvc.perform(post(String.format("/%s", ControllerPaths.CREATE_SALES_REPORT))
				.content(stringWriter.toString())
				.contentType(mediaType))
				.andExpect(status().isOk());
		
		Mockito.verify(mySampleWebAppService, Mockito.times(1)).createSalesReport(salesReport);
	}

	@Configuration
	@Import(ApplicationConfig.class)
	static class ContextConfiguration {
		@Bean
		@Autowired
		public MySampleWebAppController mySampleWebAppController(MySampleWebAppService mySampleWebAppService) {
			return new MySampleWebAppController(mySampleWebAppService);
		}
		
		@Bean
		public MySampleWebAppService mySampleWebAppService(){
			return Mockito.mock(MySampleWebAppService.class);
		}
		
		@Bean
		public MySampleWebAppRepository mySampleWebAppRepository(){
			return Mockito.mock(MySampleWebAppRepository.class);
		}
	}
}

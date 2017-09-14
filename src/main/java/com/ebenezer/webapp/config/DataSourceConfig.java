package com.ebenezer.webapp.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import({PropertySourceConfig.class, PropertyConfig.class})
public class DataSourceConfig {
	private final static String PACKAGE_TO_SCAN = "com.ebenezer.webapp";
	@Value("${db.driverClassName}")
	private String driverClassName;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.url}")
	private String url;
	@Value("${db.type}")
	private String dbType;
	@Value("${db.generateDDL}")
	private String generateDDL;
	@Value("${db.generateDDLType}")
	private String generateDDLType;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
		EnrichedHibernateJpaVendor vendor = new EnrichedHibernateJpaVendor();
		vendor.setDatabase(Database.valueOf(dbType));
		vendor.setGenerateDdl(Boolean.valueOf(generateDDL));
		vendor.setShowSql(true);
		vendor.setGenerateDDLType(generateDDLType);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendor);
		factory.setPackagesToScan(PACKAGE_TO_SCAN);
		factory.setDataSource(dataSource);
		
		return factory;
	}
	
	@Bean
	@Autowired
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean.getObject());
		
		return transactionManager;
    }
}

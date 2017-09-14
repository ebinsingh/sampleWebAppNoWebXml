package com.ebenezer.webapp.config;

import java.util.Map;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class EnrichedHibernateJpaVendor extends HibernateJpaVendorAdapter {
	private String generateDDLType;

	public void setGenerateDDLType(String generateDDLType) {
		this.generateDDLType = generateDDLType;
	}
	
	@Override
	public Map<String, Object> getJpaPropertyMap(){
		Map<String, Object> jpaProperties = super.getJpaPropertyMap();
		jpaProperties.put(AvailableSettings.HBM2DDL_AUTO, generateDDLType);
		
		return jpaProperties;
	}
}

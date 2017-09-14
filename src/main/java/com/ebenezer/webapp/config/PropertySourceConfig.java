package com.ebenezer.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/properties/local.properties")
@Configuration
public class PropertySourceConfig {

}

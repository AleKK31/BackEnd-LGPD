package com.eng.lgpd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.eng.lgpd.services.DBservice;

@Profile("test")
@Configuration
public class TestConfig {
	
	@Autowired
	public DBservice dbService;
	
	@Bean
	public void instanciaDB() {
		this.dbService.intanciaDB();
	}
}

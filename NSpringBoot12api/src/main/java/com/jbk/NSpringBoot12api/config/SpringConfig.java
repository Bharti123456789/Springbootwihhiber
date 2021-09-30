package com.jbk.NSpringBoot12api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.jbk.NSpringBoot12api.entity.Admin;
import com.jbk.NSpringBoot12api.entity.Country;
import com.jbk.NSpringBoot12api.entity.Employee;


@Configuration
public class SpringConfig {
	@Autowired
	DataSource dataSource;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setAnnotatedClasses(Employee.class,Admin.class,Country.class);
		return sessionFactory;
	}

}

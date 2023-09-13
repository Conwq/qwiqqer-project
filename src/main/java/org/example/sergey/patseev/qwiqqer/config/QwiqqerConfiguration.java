package org.example.sergey.patseev.qwiqqer.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "org.example.sergey.patseev.qwiqqer")
@EnableWebMvc
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
@RequiredArgsConstructor
public class QwiqqerConfiguration {
	private final Environment env;

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setMinPoolSize(Integer.parseInt(env.getRequiredProperty("database.source.hibernate.min_pool_size")));
		dataSource.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("database.source.hibernate.max_pool_size")));
		dataSource.setJdbcUrl(env.getRequiredProperty("database.source.hibernate.url"));
		dataSource.setDriverClass(env.getRequiredProperty("database.source.hibernate.driver"));
		dataSource.setUser(env.getRequiredProperty("database.source.hibernate.username"));
		dataSource.setPassword(env.getRequiredProperty("database.source.hibernate.password"));
		return dataSource;
	}

	@Bean
	public Properties hibernateProperties(){
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", env.getRequiredProperty("database.source.hibernate.dialect"));
		return hibernateProperties;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
}

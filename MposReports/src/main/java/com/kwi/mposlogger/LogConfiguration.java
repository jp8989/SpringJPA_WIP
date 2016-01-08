package com.kwi.mposlogger;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.kwi.mposlogger")
@ComponentScan({ "com.kwi.mposlogger" })
public class LogConfiguration {

    @Bean
    public DataSource dataSource() throws NamingException {
    	
    	/*
    	Example on how to retrieve a data source object from a JNDI naming service.
    	If jndi lookup fails than return local embedded datasource for junit.
		*/
    	try {
    		Context ctx = new InitialContext();
    		return (DataSource)ctx.lookup("jdbc/kwidb"); 
    	} catch (Exception e) {
    		e.printStackTrace();
            return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.DERBY).build();    		
     	}
 	
    	
    	/*
    	Example on how to register a data source object with a JNDI naming service.
		*/
    	// DataSource ds = makeDataSource("kwidb");
    	// Context ctx = new InitialContext();
    	// ctx.bind("jdbc/kwidb", ds);
    	        
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws SQLException, NamingException {
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.kwi.mposlogger");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException, NamingException {
        return new JpaTransactionManager(entityManagerFactory());
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
}

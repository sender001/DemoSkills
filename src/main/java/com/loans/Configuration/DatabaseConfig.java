package com.loans.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


/**
 * Created by sender on 13.02.2017.
 */
@Configuration
public class DatabaseConfig {

    @Autowired
    private Environment env;

  /*  @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;*/


    /*@Bean
    public DataSource dataSource(){

        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql").addScript("data.sql").build();
        return dataSource;
    }*/

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource());

        // Classpath scanning of @Component, @Service, etc annotated class
        entityManagerFactory.setPackagesToScan(
                env.getProperty("entitymanager.packagesToScan"));

        // Vendor adapter
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.MYSQL);

        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager =
                new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                entityManagerFactory().getObject());
        return transactionManager;
    }


}

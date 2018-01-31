package com.pixelweb.data.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.pixelweb.repository.second",
        entityManagerFactoryRef = "secondEntityManagerFactory",
        transactionManagerRef = "secondTranssationManager"
)
public class SecondDB {

    @Value("${datasource.second.driver}")
    private String driver;
    @Value("${datasource.second.url}")
    private String url;
    @Value("${datasource.second.username}")
    private String username;
    @Value("${datasource.second.password}")
    private String pass;

    @Bean
    public DataSource secondDataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(pass);
        return new HikariDataSource(config);
    }
    @Bean
    public PlatformTransactionManager secondTranssationManager(){
        return new JpaTransactionManager(secondEntityManagerFactory().getObject());
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(secondDataSource());
        factory.setPackagesToScan("com.pixelweb.model");
        return factory;
    }
}



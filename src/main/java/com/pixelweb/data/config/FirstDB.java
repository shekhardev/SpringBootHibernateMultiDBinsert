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
        basePackages = "com.pixelweb.repository.first",
        entityManagerFactoryRef = "firstEntityManagerFactory",
        transactionManagerRef = "firstTranssationManager"
)
public class FirstDB {

    @Value("${datasource.first.driver}")
    private String driver;
    @Value("${datasource.first.url}")
    private String url;
    @Value("${datasource.first.username}")
    private String username;
    @Value("${datasource.first.password}")
    private String pass;

    @Bean
    public DataSource firstDataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(pass);
        return new HikariDataSource(config);
    }
    @Bean
    public PlatformTransactionManager firstTranssationManager(){
        return new JpaTransactionManager(firstEntityManagerFactory().getObject());
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(firstDataSource());
        factory.setPackagesToScan("com.pixelweb.model");
        return factory;
    }
}

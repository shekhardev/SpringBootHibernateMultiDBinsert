package com.pixelweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.pixelweb"},
						exclude = {
								HibernateJpaAutoConfiguration.class,
								DataSourceAutoConfiguration.class,
								DataSourceTransactionManagerAutoConfiguration.class
						})
@EnableTransactionManagement
public class SbMultiSourceDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMultiSourceDataApplication.class, args);
	}
}

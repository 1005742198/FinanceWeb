package com.obob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages={"com.obob"})
@PropertySource("classpath:config.properties")
@ImportResource({"classpath:/spring/spring-mvc.xml"})
public class FinanceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceWebApplication.class, args);
	}
}

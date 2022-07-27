package com.grpbg.Poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
//@ComponentScan(basePackageClasses = com.grpbg.Poc.Controller.AppController.class)
//@Controller("/")
//@EnableAutoConfiguration
public class PocCabChangesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocCabChangesApplication.class, args);
	}

}

package com.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.inventory")
@ComponentScan(basePackages = "com.inventory")
public class InventoryDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryDockerApplication.class, args);
	}
}

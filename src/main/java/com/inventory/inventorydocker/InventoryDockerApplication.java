package com.inventory.inventorydocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.inventory.inventorydocker")
@ComponentScan(basePackages = "com.inventory.inventorydocker")
public class InventoryDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryDockerApplication.class, args);
	}
}

package com.inventory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/test")
	public String sahHi() {
		System.out.println("-----------------in test controller");
		return "Hi Mahesh";
	}
	
	@RequestMapping("/hello")
	public String sahHai() {
		System.out.println("-----------------in test controller");
		return "Hi Mahesh";
	}

}

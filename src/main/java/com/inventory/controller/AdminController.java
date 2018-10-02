package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.inventory.dao.JsonInventory;
import com.inventory.service.AdminService;


@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
/*	@RequestMapping("/getJsonResponce")
	public String ok() {
		System.out.println("----------------------------");
		jsonInventory.getInventoryJson();
		return jsonInventory.getInventoryJson();
	}*/
	@RequestMapping(value="/getJsonResponce", method = RequestMethod.GET)
	public String registrationSubmit(@RequestParam(value="date", required = false) String date)
    {
		System.out.println("--------getJsonResponce--------"+date);
		try {
			if(date==null) {
				date = "today";
			}
			System.out.println("video------------------------------"+date);
			return adminService.getInventory(date);
		}
		catch(Exception e) {
			return "fail";
		}
		
    }

}

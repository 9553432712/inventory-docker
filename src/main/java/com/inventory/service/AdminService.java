package com.inventory.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.JsonInventory;

@Service
public class AdminService {
	
	@Autowired
	JsonInventory jsonInventory;
	
	public String getInventory(String sDate2){
		String result ="";
		//String sDate2 = "02-Oct-2018";
		try{
			if(sDate2!=null && sDate2.equalsIgnoreCase("today")) {
				 result = jsonInventory.getInventoryJson();
			}
			else {
				SimpleDateFormat formatter2=new SimpleDateFormat("dd-MMM-yyyy");
				Date date2=formatter2.parse(sDate2);
				result = date2.toString();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return sDate2;
		}
		return result;
	}

}

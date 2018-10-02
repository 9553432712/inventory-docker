package com.inventory.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.JsonInventory;
import com.inventory.util.CommonUtility;

@Service
public class AdminService {
	
	@Autowired
	JsonInventory jsonInventory;
	
	public String getInventory(String sDate2){
		String result ="";
		//String sDate2 = "02-Oct-2018";
		try{
			SimpleDateFormat formatter2=new SimpleDateFormat("dd-MMM-yyyy");
			Date d = new Date();
			if(sDate2!=null && sDate2.equalsIgnoreCase("today")) {
				 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				    Date date = new Date();
				    System.out.println(formatter.parse((formatter.format(date))));  
				 result = jsonInventory.getInventoryJson(formatter.parse((formatter.format(date))));
			}
			else {
				 formatter2=new SimpleDateFormat("dd-MMM-yyyy");
				Date date2=formatter2.parse(sDate2);
				//CommonUtility.difference_between_two_dates_java8(date2, date2);
				result = jsonInventory.getInventoryJson(date2);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return sDate2;
		}
		return result;
	}

}

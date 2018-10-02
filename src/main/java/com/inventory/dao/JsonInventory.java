package com.inventory.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.inventory.entity.Inventory;
import com.inventory.util.CommonUtility;



@Component
public class JsonInventory {
	@Autowired
	JdbcTemplate jdbc;
	
	public String getInventoryJson(Date d) {
		System.out.println("--------------------");
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		JSONObject jObj = new JSONObject();
			try
			{
	
				con  = jdbc.getDataSource().getConnection();
				String qry = "select p.id,p.name,p.price,p.expire_date,p.prudcttype_id,p.quality,p.sellin,pt.type,pt.rule "
						+ "from Products p, producttype pt where pt.id=p.prudcttype_id";
				st = con.createStatement();
				rs = st.executeQuery(qry);
	
				
				ArrayList<Inventory> list=new ArrayList<Inventory>();
				Map<String, String> map=new HashMap<String, String>();
				Inventory sPojo=null;
				while (rs.next())
				{
					sPojo=new Inventory();
					
					sPojo.setId(rs.getInt("id"));
					sPojo.setName(rs.getString("name"));
					sPojo.setPrice(rs.getInt("price"));
					sPojo.setExpire_date(rs.getDate("expire_date"));
					sPojo.setPrudcttype_id(rs.getInt("prudcttype_id"));
					//sPojo.setQuality(rs.getInt("quality"));
					//sPojo.setSellin(rs.getInt("sellin"));
					sPojo.setType(rs.getString("type"));
					sPojo.setRule(rs.getString("rule"));
					
					list.add(sPojo);
					ArrayList dateDiff = CommonUtility.difference_between_two_dates_java8(rs.getDate("expire_date"), d);
					switch (rs.getInt("prudcttype_id")) {
					case 2:
						if((int)dateDiff.get(0)>0) {
							if(rs.getInt("sellin")-(int)dateDiff.get(0)>=0) {
								sPojo.setSellin(rs.getInt("sellin")-(int)dateDiff.get(0));
							}
							else {
								sPojo.setSellin(0);
							}
							if(rs.getInt("quality")+(int)dateDiff.get(0)>=0 && rs.getInt("quality")+(int)dateDiff.get(0)<=50) {
								sPojo.setQuality(rs.getInt("quality")+(int)dateDiff.get(0));
							}
							else {
								sPojo.setQuality(0);
							}
						}
						else {
							sPojo.setQuality(0);
							sPojo.setSellin(0);
						}
						break;
					case 5:
						if((int)dateDiff.get(0)<0)
						{
							sPojo.setSellin(0);
							sPojo.setQuality(0);
						}
						else if((int)dateDiff.get(0)<=10)
						{
							sPojo.setSellin(rs.getInt("sellin")-(int)dateDiff.get(0));
							sPojo.setQuality(rs.getInt("quality")+(int)dateDiff.get(0)*2);
						}
						else if((int)dateDiff.get(0)>0) 
						{
							if(rs.getInt("sellin")-(int)dateDiff.get(0)>=0) {
								sPojo.setSellin(rs.getInt("sellin")-(int)dateDiff.get(0));
							}
							else {
								sPojo.setSellin(0);
							}
							if(rs.getInt("quality")+(int)dateDiff.get(0)>=0 && rs.getInt("quality")+(int)dateDiff.get(0)<=50) {
								sPojo.setQuality(rs.getInt("quality")+(int)dateDiff.get(0));
							}
							else {
								sPojo.setQuality(0);
							}
						}
						else {
							sPojo.setQuality(0);
							sPojo.setSellin(0);
						}
						break;
					case 4:
						sPojo.setQuality(rs.getInt("quality"));
						sPojo.setSellin(rs.getInt("sellin"));
						break;
					case 1:
					case 3:
						if((int)dateDiff.get(0)>0) {
							if(rs.getInt("sellin")-(int)dateDiff.get(0)>=0) {
								sPojo.setSellin(rs.getInt("sellin")-(int)dateDiff.get(0));
							}
							else {
								sPojo.setSellin(0);
							}
							if(rs.getInt("quality")-(int)dateDiff.get(0)>=0 && rs.getInt("quality")-(int)dateDiff.get(0)<=50) {
								sPojo.setQuality(rs.getInt("quality")-(int)dateDiff.get(0));
							}
							else {
								sPojo.setQuality(0);
							}
						}
						else {
							sPojo.setQuality(0);
							sPojo.setSellin(0);
						}
						break;

					default:
						break;
					}
					
					
	
				}
				//System.out.println(list);
	
				jObj.put("inventorydetails",list);
	
				System.out.println(list+"---------------------------------"+jObj.toString());
	
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return jObj.toString();

	}
		
}


package com.inventory.util;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.MultiValueMap;
public class CommonUtility 
{
	
	public static ArrayList difference_between_two_dates_java8(Date d1, Date d2)
	{
		ArrayList result = new ArrayList(); 
	     //LocalDate dateOfBirth = LocalDate.of(1980, Month.JULY, 4);
		LocalDate dateOfBirth = LocalDate.of(d2.getYear(), d2.getMonth(),d2.getDate());
	     LocalDate currentDate = LocalDate.of(d1.getYear(), d1.getMonth(),d1.getDate());
	     int diffInDays = (int) ChronoUnit.DAYS.between(dateOfBirth, currentDate);
	     int diffInMonths = (int) ChronoUnit.MONTHS.between(dateOfBirth, currentDate);
	     int diffInYears = (int) ChronoUnit.YEARS.between(dateOfBirth, currentDate);
	     System.out.println("diffInDays"+diffInDays);
	     System.out.println("diffInMonths"+diffInMonths);
	     System.out.println("diffInYears"+diffInYears);
	     result.add(diffInDays);
	     result.add(diffInMonths);
	     result.add(diffInYears);
	     return result;
	}
	public static HashMap<String, String> convertMultiToRegularMap(MultiValueMap<String, String> m) 
	{
	    HashMap<String, String> map = new HashMap<String, String>();
	    if (m == null)
	    {
	        return map;
	    }
	    for (Entry<String, List<String>> entry : m.entrySet()) 
	    {
	        StringBuilder sb = new StringBuilder();
	        for (String s : entry.getValue()) 
	        {
	            if (sb.length() > 0) 
	            {
	                sb.append(',');
	            }
	            sb.append(s);
	        }
	        map.put(entry.getKey(), sb.toString());
	    }
	    return map;
	}
	public static String dropDownWithJSON()
	{
		return null;
	}
	public static ArrayList getFromResultSet(ResultSet lrs)
	{
		
		ArrayList resultDataList	= new ArrayList();
		  ArrayList headerList 		= new ArrayList();
		  ArrayList tempList 		= new ArrayList();
		  
		  HashMap columnHashData = new HashMap();
			  
		try
		{	  
			ResultSetMetaData rsMetaData=lrs.getMetaData();
		      int columnCount=rsMetaData.getColumnCount();

		    	 if(columnCount>1)
		    	 { 
				      for(int i=1;i<=columnCount;i++)
				      {
				    	  headerList.add(rsMetaData.getColumnName(i));
				      } 
		    	 }
		    	 else
		    	 {
		    		 headerList.add(rsMetaData.getColumnName(1));
		    	 } 
		   	   
				      while(lrs.next())
				          {
				    	  	columnHashData = new HashMap();
				    	  	
				    	  	if(columnCount>1)
					    	 { 
						    
				              for(int loopCount=1;loopCount<=columnCount;loopCount++)
				              {
				            	// System.out.println("ColumnValue:"+  lrs.getString(loopCount)); 
				                if(lrs.getString(loopCount)!=null)                
				                {
				                	//System.out.println("Data in Main :"+lrs.getString(loopCount));
				                	 columnHashData.put(headerList.get(loopCount-1).toString().trim(), lrs.getString(loopCount));  
				                }
				               else
				                {
				            	   columnHashData.put(headerList.get(loopCount-1).toString().trim(), "");
				                  //System.out.println("In Varcharcommma");
				                }
				               
				              
				              }      
				              resultDataList.add(columnHashData); 
				           }
			    	     else
				    	  {  
			    	    	 
			    	    	 if(lrs.getString(1)!=null)                
				                {
				                	//System.out.println("Data in Main :"+lrs.getString(loopCount));
			                	 	columnHashData.put(headerList.get(0).toString().trim(), lrs.getString(1));
				                }
				               else
				                {
				                	 columnHashData.put(headerList.get(0).toString().trim(), ""); 
				                  //System.out.println("In Varcharcommma");
				                }
			    	    	  
			    	    	 resultDataList.add(columnHashData);
				    	  }
				        }
				   	  

				      //return resultDataList;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return resultDataList;
	}
	public static String createStrComboBoxAuto(String name,ArrayList dataList,String selVal,String style,String action,boolean def,boolean type,String DisplayText)  
	  {
	      String strOut="<SELECT NAME='"+name+"' id='"+name+"' class='"+style+"' "+ action+">";      
	      if(selVal==null)
	      {
	          selVal="";
	      }
	      selVal=selVal.trim();
	      
	      if(def)
	      {
	    	  if(!DisplayText.equals(""))
	    	  {
	    		  strOut=strOut+"<option value='-1' title="+DisplayText+">"+DisplayText+"</option>";    		  
	    	  }
	    	  else if(type==true)
	    	  {
	    		  strOut=strOut+"<option value='-1'>-Select-</option>";
	    	  }
	    	  else
	    	  {
	    		  strOut=strOut+"<option value='-1'>All</option>";  
	    	  }
	      }
	      else if(selVal.equals("-1"))
	      {
	    	  if(!DisplayText.equals(""))
	    	  {
	    		  strOut=strOut+"<option value='-1' title='"+DisplayText+"'>"+DisplayText+"</option>";    		  
	    	  }
	    	  else if(type==true)
	    	  {
	    		  strOut=strOut+"<option value='-1' SELECTED>-Select-</option>";
	    	  }
	    	  else
	    	  {
	    		  strOut=strOut+"<option value='-1' SELECTED>All</option>";  
	    	  }    
	      }
	      strOut=strOut+populateComboWithID(dataList,selVal)+"</SELECT>";
	      return strOut;
	  }
	private static String populateComboWithID(ArrayList comboList,String cmp)
	{
			String strOut="";
			int liComboSize = 0;
			try
			{
			    if(comboList != null && !comboList.isEmpty())
			    {
			      liComboSize = comboList.size();
			      for(int i=0;i<liComboSize;i++)
			      {
			    	 
			         ArrayList dataList = (ArrayList)comboList.get(i);
			        
			         String ID=(String)dataList.get(0);
			         //System.out.println("Lengthb4ID"+ID.length());
			        // System.out.println("LengthAftertrip"+(ID.trim()).length());
			       
			        strOut=strOut+"<OPTION VALUE='"+dataList.get(0).toString().trim()+"'";
			         if ((ID.trim()).equalsIgnoreCase(cmp.trim()))
			         {
			        	// System.out.println("InsideCMP"+cmp);
			           //  System.out.println("Insideget(0)"+dataList.get(0));
			          strOut=strOut+" SELECTED";
			         }
			          strOut=strOut+" title='"+dataList.get(1).toString().trim().replaceAll("'","")+"'>"+dataList.get(1).toString().trim()+"</OPTION>";
			      }  
			    	}
			}
			catch(Exception e)
			{
				System.out.println("Exception in Combo Genration :: "+e.getLocalizedMessage());
			}
	    return strOut;
		}
	
	public static String generateRandomStr(int length) 
	{    
		Random rng= new Random();
		String characters="ABCDEFGHIJK123456789LMNPQRSTUVWXYZ";
		
		char[] text = new char[length];     
		for (int i = 0; i < length; i++)     
		{         
			text[i] = characters.charAt(rng.nextInt(characters.length()));     
		}     
		return new String(text); 
	} 
  
  
  public static String generateRandomStrSession(int length,HttpSession session,String sesValName) 
	{    
		Random rng= new Random();
		String characters="AB2C3D4E5F6G3H5KMNP9Q2R5ST8UV7W7XY6Z"; 
		
		if(length==-1)
		{
			length=Integer.parseInt("20"); 
		}
		
		char[] text = new char[length];     
		for (int i = 0; i < length; i++)     
		{         
			text[i] = characters.charAt(rng.nextInt(characters.length()));     
		}
		session.setAttribute(sesValName,"");
		session.removeAttribute(sesValName);
		session.setAttribute(sesValName, new String(text));
		return new String(text); 
	}
  
  	public static int generateRandomNo(int digCount) 
	{
  		Random rnd = new Random();
  		StringBuilder sb = new StringBuilder(digCount);
  	    for(int i=0; i < digCount; i++)
  	        sb.append((char)('0' + rnd.nextInt(10)));
  	    return Integer.parseInt(sb.toString());
	} 
  	public static String checkNull(String asCheckString)
    {
        if (asCheckString == null)
        {
            return "";
        }

        return asCheckString;
    }
    public static String checkNullObj(Object aoCheckObject)
    {
        if (aoCheckObject == null)
        {
            return "";
        }

        return aoCheckObject.toString();
    }
     public static String checkNullObject(String asCheckString)
    {
        if (asCheckString == null)
        {
            return " ";
        }

        return asCheckString;
    }
     public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
    	    Map<String, Object> retMap = new HashMap<String, Object>();

    	    if(json != JSONObject.NULL) {
    	        retMap = toMap(json);
    	    }
    	    return retMap;
    	}

    	public static Map<String, Object> toMap(JSONObject object) throws JSONException {
    	    Map<String, Object> map = new HashMap<String, Object>();

    	    Iterator<String> keysItr = object.keys();
    	    while(keysItr.hasNext()) {
    	        String key = keysItr.next();
    	        Object value = object.get(key);

    	        if(value instanceof JSONArray) {
    	            value = toList((JSONArray) value);
    	        }

    	        else if(value instanceof JSONObject) {
    	            value = toMap((JSONObject) value);
    	        }
    	        map.put(key, value);
    	    }
    	    return map;
    	}

    	public static List<Object> toList(JSONArray array) throws JSONException {
    	    List<Object> list = new ArrayList<Object>();
    	    for(int i = 0; i < array.length(); i++) {
    	        Object value = array.get(i);
    	        if(value instanceof JSONArray) {
    	            value = toList((JSONArray) value);
    	        }

    	        else if(value instanceof JSONObject) {
    	            value = toMap((JSONObject) value);
    	        }
    	        list.add(value);
    	    }
    	    return list;
    	}



}

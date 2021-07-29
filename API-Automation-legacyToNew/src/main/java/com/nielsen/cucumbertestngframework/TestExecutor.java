package com.nielsen.cucumbertestngframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.apache.poi.util.SystemOutLogger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;



//import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import cucumber.api.Scenario;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

import java.io.PrintStream;

public class TestExecutor {
public TestExecutor() {
		
	}


	public boolean initDriver() {
		ChromeOptions option = new ChromeOptions();
		return true;
		
	}


	public  ArrayList<Object> requestTheAPIGetCall(String apiURL) throws Exception {
 
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int responseCode = con.getResponseCode();
		System.out.println("responce of the GET call is "+responseCode);
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream())); 
		String inputLine ;
		StringBuffer responce = new StringBuffer();
		while((inputLine=reader.readLine())!=null)
		{
			responce.append(inputLine);
		}
		 reader.close();
		
		System.out.println("responce"+responce);
		//Convert from stringjson to jsonObject to jsonArray to List
		    JSONObject jsonObj = new JSONObject(responce.toString());
	        
	        System.out.println("Json object origin- "+jsonObj.getString("origin"));
	        
	        Iterator<String> jsonObjkeys = jsonObj.keys();
	        JSONArray jsonArray = new JSONArray();
	       // jsonArray.put(jsonObj);------->Copying all the data directly
	        while (jsonObjkeys.hasNext()){
	            String key = (String) jsonObjkeys.next();
	            jsonArray.put(jsonObj.get(key));
	        }
	        System.out.println("Json Array- "+jsonArray);
	        ArrayList<Object> listdata = new ArrayList<Object>();     
	        
	        if (jsonArray != null) { 
	           for (int i=0;i<jsonArray.length();i++){ 
	        	   try {
	            listdata.add(jsonArray.getString(i));
	        	   }
	        	   catch(Exception ex) {
	        		   listdata.add(jsonArray.getInt(i));   
	        	   }
	           } 
	        }
	        System.out.println("Array list- "+listdata);

	

		/*****we can also use java jackson lib to have this conversion in the simple way ****/
	        
		/*
		 * ObjectMapper objectMapper = new ObjectMapper(); try { List<String> countries
		 * = objectMapper.readValue(jsonObj, List.class);
		 * System.out.println("The countries are:\n " + countries); } catch(Exception e)
		 * { e.printStackTrace(); } }
		 */
		return listdata;
}
	


	public boolean validateResponse(List<Object> oldResponse, List<Object> newResponse) {
		return (oldResponse.size() == newResponse.size() && oldResponse.containsAll(newResponse) && newResponse.containsAll(oldResponse));
	//size of both lists and check if the first list contains all elements of the second list and vice versa. 	
	}
	
	
	
	

}
	
	
	

	
	
	
	
	
	 
	
	
	
	
	
	
	
	



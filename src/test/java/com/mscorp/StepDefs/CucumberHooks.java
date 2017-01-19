package com.mscorp.StepDefs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import com.mscorp.automation.webDriverCreator;

import com.thoughtworks.selenium.Wait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {
	
	
	static String appUrl = null;
	
	public static StringBuffer failedScenario = new StringBuffer(15);
	public static StringBuffer passedScenario= new StringBuffer(15);
	public static String testResults="comment";
	
	public static Map<String,String> SceanrioResults = new HashMap<String,String>();
	public static int count = 0;
	public static webDriverCreator test;
	
	@Before
	public void tearUp(Scenario scenario){
		test = new webDriverCreator(scenario.getName());
		printScenarioName(scenario);
	}
	
	@After
	public void tearDown(Scenario scenario){
		try{
			if(!getStatus(scenario).equals("1")){
				test.takescreenshot.takeScreenShotForCucumber("Screenshot"+scenario);
			}
		}catch(Exception e){
			System.out.println("Error in taking screen shot");
			e.printStackTrace();
		}finally {
			test.closeBrowserSession();
			count++;
		}
		
	}
	

	public String getStatus(Scenario scenario){
		System.out.println("Scenario ***"+scenario.getStatus());
		switch (scenario.getStatus().toUpperCase()) {
		case "PASSED":
			return "1";
		case "FAILED":
			return "2";
		default:
			return "-1";
		}
	}
	
	public void printScenarioName(Scenario scenario){
		System.out.println("Running scenario:" + scenario.getName());
	}
	
	/*@After
	public void embedJIRAComment(Scenario scenario) throws IOException, ParseException {  
			
	        if (scenario.isFailed()) {  
	            try {
	            	
	            	PropFileHandler.writeToFile(scenario.getName(), scenario.getStatus(),
	     			YamlReader.getYamlValue("propertyfilepath"));
	              	SceanrioResults.put(scenario.getName(), scenario.getStatus());
	            	failedScenario=failedScenario.append("Scenario: "+scenario.getName()+" : - {color: red}* Failed *{color}"+"\n");
	            } catch (WebDriverException wde) {  
	                System.err.println(wde.getMessage());  
	            } catch (ClassCastException cce) {  
	                cce.printStackTrace();  
	            }  
	        } else{
	        	
	             SceanrioResults.put(scenario.getName(), scenario.getStatus());
	             PropFileHandler.writeToFile(scenario.getName(), scenario.getStatus(),
	 					YamlReader.getYamlValue("propertyfilepath"));
	             
	        	passedScenario=passedScenario.append("Scenario: "+scenario.getName()+" : - {color: green}* Passed *{color}"+"\n");
	         }
	        testResults=passedScenario.toString()+failedScenario.toString();
	        getSceanrioResults();
	    }*/
	
	public Map<String,String> getSceanrioResults(){
		for (Map.Entry<String,String> entry : SceanrioResults.entrySet()) {
			  String key = entry.getKey();
			  System.out.println("scenario name==>"+ key);
			  System.out.println("scenario value==>"+ entry.getValue());
		
			}
		return SceanrioResults;
		
	}
	
}
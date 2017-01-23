/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscorp.StepDefs;

import com.mscorp.automation.webDriverCreator;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 *
 * @author ramandeep.singh
 */
public class Step_Def_Base {

	public static webDriverCreator test;
	public static String timeStamp = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
	public static String userID;
	
	public static List<String> deleteTermList = new ArrayList<String>();

	@Before
	public void initialSetUp() {
            test = new webDriverCreator(timeStamp);
	}



	@After
	public void screenShotAndConsoleLog(Scenario result) {
		screenShot(result);
		if (!(result.getStatus().contains("pass"))) {
			throw new RuntimeException(result.getName() + " got failed");
		}
                test.closeBrowserSession();
	}

	private void screenShot(Scenario result) {
		test.takescreenshot.takeScreenShotOnException(result);
         
	}

}

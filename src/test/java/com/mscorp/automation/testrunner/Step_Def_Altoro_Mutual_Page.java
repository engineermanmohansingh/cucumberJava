/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscorp.automation.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 *
 * @author manmohansingh
 */
@CucumberOptions(features = "src/test/resources/features/Story_007.feature", glue = "com.mscorp.StepDefs", plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json"})
public class Step_Def_Altoro_Mutual_Page extends AbstractTestNGCucumberTests {

}

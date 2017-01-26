/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscorp.StepDefs;

import com.mscorp.automation.webDriverCreator;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author manmohansingh
 */
@CucumberOptions(features = "src/test/resources/features/", tags = {"@cashkaro"}, format = {"json:/target/cucumber/report.html"})
public class SingleFeatureTest extends AbstractTestNGCucumberTests {

    public static webDriverCreator test;

    @BeforeClass
    public void setup() {
        test = new webDriverCreator(this.getClass().getSimpleName());
    }

    @AfterClass
    public void teardown() {
        test.closeBrowserSession();
    }
}

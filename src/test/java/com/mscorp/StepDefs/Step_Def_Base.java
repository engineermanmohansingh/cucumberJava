/*
  * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscorp.StepDefs;

import static com.mscorp.StepDefs.SingleFeatureTest.test;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 *
 * @author ramandeep.singh
 */
public class Step_Def_Base {

    @Before
    public void printScenario(Scenario scenario) {
        String className = this.getClass().getCanonicalName();
        System.out.println("_________________________________________________________");
        System.out.println("*********"+"Scenario: " + scenario.getName()+"*********");
        System.out.println("---------------------------------------------------------");
    }

    @After
    public void screenShotAndConsoleLog(Scenario result) {
        screenShot(result);
        if (!(result.getStatus().contains("pass"))) {
            throw new RuntimeException(result.getName() + " got failed");
        }
    }

    private void screenShot(Scenario result) {
        test.takescreenshot.takeScreenShotOnException(result);
        
       
       
    }

}

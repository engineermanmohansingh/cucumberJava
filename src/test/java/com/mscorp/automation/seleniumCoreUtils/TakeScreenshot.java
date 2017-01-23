/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mscorp.automation.seleniumCoreUtils;

import static com.mscorp.automation.utils.ConfigPropertyReader.getProperty;
import cucumber.api.Scenario;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class TakeScreenshot {

    WebDriver driver;
    String testname;
    String testcaseName;
    String screenshotPath = "target" + File.separator + "Screenshots";

    public TakeScreenshot(String testname, WebDriver driver) {
        this.driver = driver;
        this.testname = testname;
    }

    public void takeScreenShotForCucumber(String screenshotFileName) {

        File file = new File(System.getProperty("user.dir") + File.separator + screenshotPath);
        if (!file.isDirectory()) {
            file.mkdir();
        }
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        String saveImgFile = System.getProperty("user.dir") + File.separator + screenshotPath + File.separator + "Failure_Screenshot_" + screenshotFileName + ".jpg";
        System.out.println("Save Image File Path : " + saveImgFile);
        try {
            FileUtils.copyFile(scrFile, new File(saveImgFile));
        } catch (IOException e) {
            System.out.println("Error in saving file");
            e.printStackTrace();
        }

    }

    public void takeScreenshot(Scenario scenario) {
        screenshotPath = (getProperty("screenshot-path") != null) ? getProperty("screenshot-path") : screenshotPath;
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_a");
        Date date = new Date();
        String date_time = dateFormat.format(date);
        File file = new File(
                System.getProperty("user.dir") + File.separator + screenshotPath);
        boolean exists = file.exists();
        if (!exists) {
            new File(System.getProperty("user.dir") + File.separator + screenshotPath)
                    .mkdir();
        }

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
        try {

            String saveImgFile = System.getProperty("user.dir") + File.separator + screenshotPath + File.separator + date_time + "_screenshot_" + testcaseName + ".png";
            Reporter.log("[INFO]: Save Image File Path : " + saveImgFile, true);
            FileUtils.copyFile(scrFile, new File(saveImgFile));
        } catch (IOException e) {
        }
    }

    public void takeScreenShotOnException(Scenario scenarioName) {
        String testcaseName = scenarioName.getName().toUpperCase();
        String takeScreenshot = getProperty("take-screenshot");
        Reporter.log("*************************************", true);
        Reporter.log("Scenario Name: " + testcaseName, true);
        Reporter.log("Scenario Result: " + scenarioName.getStatus().toUpperCase(), true);
        testcaseName = testcaseName.trim();
        if (scenarioName.isFailed()) {
            if (takeScreenshot.equalsIgnoreCase("true") || takeScreenshot.equalsIgnoreCase("yes")) {
                try {
                    if (driver != null) {
                        takeScreenshot(scenarioName);
                    }
                } catch (Exception ex) {
                    Reporter.log("[TAKESCREENSHOT EXCEPTION]Driver is null while taking screen shot", true);
                }
            }
        }
    }

}

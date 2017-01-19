package com.mscorp.automation.seleniumCoreUtils;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GetPage extends seleniumCore {
    
    protected WebDriver webdriver;
    
    public GetPage(WebDriver driver) {
        super(driver);
        this.webdriver = driver;
        
    }

    // TODO: put this in right place, create dedicated class for frame and
    // window handlers
//	protected void switchToNestedFrames(String frameNames) {
//		switchToDefaultContent();
//		String[] frameIdentifiers = frameNames.split(":");
//		for (String frameId : frameIdentifiers) {
//			wait.waitForFrameToBeAvailableAndSwitchToIt(getLocator(frameId
//					.trim()));
//	}
//	}
    protected void switchToNestedFrames(WebElement... frameNames) {
        switchToDefaultContent();
        for (WebElement token : frameNames) {
            wait.hardWait(1);
            wait.waitForElementToBeVisible(token);
            driver.switchTo().frame(token);
        }
        
    }
    
    public WebElement finder(By locator) {
        WebElement webElement = null;
        try {
            webElement = driver.findElement(locator);
        } catch (NoSuchElementException e) {
            logMessage("[ELEMENT NOT FOUND] : You might have to update the locator:-" + locator);
        }
        
        return webElement;
    }

    /*protected void isStringMatching(String actual, String expected) {
		Assert.assertEquals(actual, expected);
		logMessage("ACTUAL STRING : " + actual);
		logMessage("EXPECTED STRING :" + expected);
		logMessage("String compare Assertion passed.");
	}*/
    protected void enterText(WebElement element, String text) {
        wait.waitForElementToBeClickable(element);
        if (getBrowser().equalsIgnoreCase("chrome")) {
            clickUsingActionScript(element);
        } else {
            element.click();
        }
        element.clear();
        element.sendKeys(text);
        logMessage("Entered Text " + text);
    }
    
    protected void verifyElementText(WebElement elementName, String expectedText) {
        wait.waitForElementToBeVisible(elementName);
        Assert.assertEquals("ASSERT FAILED: element '" + elementName
                + "' Text is not as expected: ", elementName.getText().trim(), expectedText);
        logMessage("ASSERT PASSED: element " + elementName
                + " is visible and Text is " + expectedText);
    }
    
    protected void verifyElementTextContains(WebElement elementName,
            String expectedText) {
        String actualText = elementName.getText();
        wait.waitForElementToBeVisible(elementName);
        Assert.assertTrue("ASSERT FAILED: element '" + elementName
                + "' Text is not as expected, actual text : " + actualText + ", Expected text : - " + expectedText, actualText
                .trim().toUpperCase().contains(expectedText.toUpperCase()));
        logMessage("ASSERT PASSED: element " + elementName
                + " is visible and Text is " + expectedText);
    }
    
    protected boolean isElementDisplayed(WebElement elementName)
            throws NoSuchElementException {
        boolean result = wait.waitForElementToBeVisible(elementName)
                .isDisplayed();
        Assert.assertTrue("ASSERT FAILED: element '" + elementName
                + "' is not displayed.", result);
        logMessage("ASSERT PASSED: element " + elementName + " is displayed.");
        return result;
    }
    
    public void hoverusingjavascript(WebElement e) {
        hardWaitForIEBrowser(2);
        String javascript = "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj)";
        ((JavascriptExecutor) driver).executeScript(javascript, e);
    }
    
    public void hoverOutusingjavascript(WebElement e) {
        hardWaitForIEBrowser(2);
        String javascript = "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseout\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj)";
        ((JavascriptExecutor) driver).executeScript(javascript, e);
    }
    
    protected boolean isElementEnabled(WebElement elementName, boolean expected) {
        wait.waitForElementToBeVisible(elementName);
        boolean result = expected && elementName.isEnabled();
        Assert.assertTrue("ASSERT FAILED: element '" + elementName
                + "' is  ENABLED :- " + !expected, result);
        logMessage("ASSERT PASSED: element " + elementName + " is enabled :- "
                + expected);
        return result;
    }
    
    public void clickAndHold(WebElement element) {
        Actions act = new Actions(driver);
        act.clickAndHold(element).build().perform();
    }
    
    public void clickUsingActionScript(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    
    private By getBy(String locatorType, String locatorValue) {
        switch (Locators.valueOf(locatorType)) {
            case id:
                return By.id(locatorValue);
            case xpath:
                return By.xpath(locatorValue);
            case css:
                return By.cssSelector(locatorValue);
            case name:
                return By.name(locatorValue);
            case classname:
                return By.className(locatorValue);
            case linktext:
                return By.linkText(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }

    /*
        Page methods for webElements 
        
     */
    protected void isElementNotDisplayed(WebElement elementName) {
        wait.resetImplicitTimeout(5);
        Boolean status = false;
        try {
            status = elementName.isDisplayed();
            Assert.assertFalse("Assertion Failed : Element is displayed", status);
            logMessage("Assertion Passed : Element " + elementName + " is not displayed ");
        } catch (NoSuchElementException e) {
            logMessage("Assertion Passed : Element " + elementName + " is not displayed ");
        } finally {
            wait.resetImplicitTimeout(wait.timeout);
        }
    }
    
}

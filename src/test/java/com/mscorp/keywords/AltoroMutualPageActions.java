package com.mscorp.keywords;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mscorp.automation.seleniumCoreUtils.GetPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AltoroMutualPageActions extends GetPage {

    By username = By.cssSelector("#uid");
    By password = By.cssSelector("#passw");
    By bankLoginLink = By.cssSelector("#_ctl0__ctl0_Content_AccountLink");
    By loginButton = By.cssSelector("input[name=\"btnSubmit\"]");
    By h1Text = By.tagName("h1");
    By signOff = By.linkText("Sign Off");
    By signIn = By.linkText("Sign In");

    public AltoroMutualPageActions(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void verifyUserIsOnLoginPage() {
        verifyPageTitleContains("Altoro Mutual");
        logMessage("User is on correct page!!");
    }

    public void launchLoginLink() {
        WebElement element = driver.findElement(By.id("_ctl0__ctl0_Content_AccountLink"));
        isElementDisplayed(element);
        click(element);
    }

    public void inputUserName(String name) {
        isElementDisplayed(finder(username));
        finder(username).sendKeys(name);
    }

    public void inputPassword(String pass) {
        isElementDisplayed(finder(password));
        finder(password).sendKeys(pass);
    }

    public void clickOnLoginButton() {
        isElementDisplayed(finder(loginButton));
        finder(loginButton).click();
    }

    public void assertUserIsAbleToViewDashboard() {
        wait.hardWait(2);
        Assert.assertTrue(finder(h1Text).getText().contains("Hello Admin User"));

    }

    public void clickOnSignOffButton() {
        isElementDisplayed(finder(signOff));
        finder(signOff).click();

    }

    public void assertDefaultPageIsAvailable() {
        isElementDisplayed(finder(signIn));
        String url = driver.getCurrentUrl();
        logMessage("Current URL :-" + url);
        Assert.assertTrue(url.contains("default"));
    }

    public void clickOnLinks(List<String> linkList) {

        for (String text : linkList) {
            logMessage("clicked on the link :-" + text);
            isElementDisplayed(finder(By.xpath("//a[contains(.,'" + text + "')]")));
            finder(By.xpath("//a[contains(.,'" + text + "')]")).click();

        }
    }

}

package com.mscorp.keywords;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.mscorp.automation.seleniumCoreUtils.GetPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CashKaroPageActions extends GetPage {

    By username = By.cssSelector("#uname");
    By password = By.cssSelector("#pwd-txt");
    By loginButton = By.cssSelector("#sign_in");
    By myAccount = By.linkText("MY ACCOUNT");
    By Logout = By.linkText("LOGOUT");
    By signIn = By.linkText("SIGN IN");
    By loginFrame = By.className("cboxIframe");

    public CashKaroPageActions(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void verifyUserIsOnLoginPage() {
        verifyPageTitleContains("Coupons, Promo Codes & Cashback Offers on 1500+ Sites");
        logMessage("User is on correct page!!");
    }

    public void launchSignInLink() {
        WebElement element = finder(signIn);
        isElementDisplayed(element);
        click(element);
    }

    public void switchToLoginFrame() {
        wait.waitForFrameToBeAvailableAndSwitchToIt(loginFrame);
    }

    public void inputUserName(String name) {
        isElementDisplayed(finder(username));
        finder(username).sendKeys(name);
    }

    public void inputPassword(String pass) {
        isElementDisplayed(finder(password));
        click(finder(password));
        finder(password).sendKeys(pass);
    }

    public void clickOnSignInButton() {
        isElementDisplayed(finder(loginButton));
        finder(loginButton).click();
    }

    public void assertUserIsLoggedIn() {
        isElementDisplayed(finder(myAccount));
        Assert.assertTrue(finder(myAccount).isEnabled());

    }

    public void clickOnSignOffButton() {
        isElementDisplayed(finder(Logout));
        finder(Logout).click();

    }

   

   

}

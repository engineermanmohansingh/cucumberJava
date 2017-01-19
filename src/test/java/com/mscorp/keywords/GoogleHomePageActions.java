package com.mscorp.keywords;

import org.openqa.selenium.WebDriver;

import com.mscorp.automation.seleniumCoreUtils.GetPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePageActions extends GetPage {

    @FindBy(css = "input[title=\"Search\"]")
    WebElement input_text;

    @FindBy(css = "a[href=\"http://www.bing.com/\"]")
    WebElement search_Result;

    @FindBy(css = "a[href=\"http://www.bing.com/\"]")
    WebElement link_qainfotech;
    
    @FindBy(css= "input[value=\"Google Search\"]")
    WebElement btn_googleSearch;

    public GoogleHomePageActions(WebDriver driver) {
        super(driver);
    }

    public void verifyUserIsOnGoogleSearchHomePage() {
        verifyPageTitleExact("Google");
        isElementDisplayed(input_text);
        logMessage("User is on Google home page");
    }

    public void enterTextAndClickOnSearchPage(String text) {
        enterText(input_text, text);

        try {
        } catch (Exception e) {
            btn_googleSearch.click();
        };
        logMessage("User enter text " + text + " and clicks on google search button");
    }

    public void searchResultDisplayed() {
        isElementDisplayed(search_Result);
    }

    public void verifyCompanyWebsiteLinkIsPresentAtTop() {
        isElementDisplayed(link_qainfotech);
    }

    public void clickOnQainfotechWebsiteLink() {
        click(link_qainfotech);
        logMessage("User clicks on the Company link avaialable on search results page");
    }
}

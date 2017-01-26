package com.mscorp.StepDefs;

import static com.mscorp.StepDefs.SingleFeatureTest.test;
import com.mscorp.automation.webDriverCreator;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.java.en.*;
import java.util.List;

public class Stepdefs_CashKaroLoginPage {
//I am on login page "http://www.cashkaro.com"

    @Given("^I am on login page \"([^\"]*)\"$")
    public void LoginPage(String url) {
        test.launchApplication(url);
        test.cashKaro.launchSignInLink();
        test.cashKaro.verifyUserIsOnLoginPage();

    }

    @When("^I enter valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterUsernameAndPassword(String user, String pass) {
        test.cashKaro.switchToLoginFrame();
        test.cashKaro.inputUserName(user);
        test.cashKaro.inputPassword(pass);
    }

    @And("^I press SignIn button$")
    public void HitGoButton() {
        test.cashKaro.clickOnSignInButton();
    }

    @Then("^I should be able to see My Account button$")
    public void assertUserIsLoggedIn() {
        test.cashKaro.switchToDefaultContent();
        test.cashKaro.assertUserIsLoggedIn();
    }

    @When("^I click on sign off button$")
    public void PerformSignOffAction() {
        test.cashKaro.clickOnSignOffButton();
    }

}

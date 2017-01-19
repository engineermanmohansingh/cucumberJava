package com.mscorp.StepDefs;

import com.mscorp.automation.webDriverCreator;
import cucumber.api.java.en.And;

import cucumber.api.java.en.*;

public class Stepdefs_AltoroMutualLoginPage {

    webDriverCreator test = CucumberHooks.test;

    @Given("^I am on test fire login page \"([^\"]*)\"$")
    public void alotoroMutualLoginPage(String url) {
        test.launchApplication(url);
        test.altoroMutual.launchLoginLink();
        test.altoroMutual.verifyUserIsOnLoginPage();

    }

    @When("^I enter valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enterUsernameAndPassword(String user, String pass) {
        test.altoroMutual.inputUserName(user);
        test.altoroMutual.inputPassword(pass);
    }

    @And("^I press Go button$")
    public void HitGoButton() {
        test.altoroMutual.clickOnLoginButton();
    }

    @Then("^I am on admin dashboard page$")
    public void assertUserIsLoggedIn() {
        test.altoroMutual.assertUserIsAbleToViewDashboard();
    }
    
    @When("^I click on sign off button$")
    public void PerformSignOffAction(){
        test.altoroMutual.clickOnSignOffButton();
    }
    
    @Then("^I should be on the default page$")
    public void assertDefaultPageUrl(){
        test.altoroMutual.assertDefaultPageIsAvailable();
    }
}

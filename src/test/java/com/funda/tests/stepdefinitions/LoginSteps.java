package com.funda.tests.stepdefinitions;

import com.funda.tests.pages.HomePage;
import com.funda.tests.pages.LoginPage;
import com.funda.tests.test_base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginSteps extends TestBase {
    @Before
    public void initPageObjects() {
        if (homePage == null) homePage = new HomePage(page);
        if (loginPage == null) loginPage = new LoginPage(page);
    }

    @When("User clicks on {string} button")
    public void user_clicks_on_login(String string) {
        homePage.inLoggenButtonClick();

    }

    @When("User enters valid email {string} and password {string}")
    public void user_enters_valid_email_and_password(String string, String string2) {
        page.waitForLoadState();
        loginPage.enterUserName(dotenv.get("USERNAME"));
        loginPage.enterPassword(dotenv.get("PASSWORD"));
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User logs in successfully")
    public void user_logs_in_successfully() {
        page.waitForLoadState();
        homePage.assertAccountButtonVisibility();
    }
}

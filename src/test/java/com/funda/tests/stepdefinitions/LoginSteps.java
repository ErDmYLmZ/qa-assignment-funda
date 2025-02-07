package com.funda.tests.stepdefinitions;

import com.funda.tests.pages.HomePage;
import com.funda.tests.pages.LoginPage;
import com.funda.tests.test_base.TestBase;
import com.funda.tests.utils.ConfigurationReader;
import com.funda.tests.utils.CsvReader;
import com.funda.tests.utils.DotEnvToSystemEnv;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginSteps extends TestBase {
    private static final Map<String, String> testDataMap = new HashMap<>();


    @Before
    public void initPageObjects() {
        if (homePage == null) homePage = new HomePage(page);
        if (loginPage == null) loginPage = new LoginPage(page);
        loadTestData();
    }

    private void loadTestData() {
        String loginTestCredentialsCsvPath = ConfigurationReader.get("loginTestCredentialsCsvPath");
        List<String[]> loginTestCredentials = CsvReader.readCsvData(loginTestCredentialsCsvPath);
        if (loginTestCredentials.isEmpty()) {
            throw new IllegalStateException("CSV file is empty or incorrect");
        }
        for (int i = 0; i < loginTestCredentials.size(); i++) {
            testDataMap.put("email" + i, loginTestCredentials.get(i)[0]);
            testDataMap.put("password" + i, loginTestCredentials.get(i)[1]);
        }
    }

    @When("User clicks on Inloggen button")
    public void user_clicks_on_login() {
        homePage.inLoggenButtonClick();
    }

    @When("User enters valid email {string} and password {string}")
    public void user_enters_valid_email_and_password(String emailPlaceholder, String passwordPlaceholder) {
        String email = DotEnvToSystemEnv.getEnvValue(emailPlaceholder);
        String password = DotEnvToSystemEnv.getEnvValue(passwordPlaceholder);
        if (email == null || password == null) {
            throw new IllegalArgumentException("No available test data for : " + emailPlaceholder + ", " + passwordPlaceholder);
        }
        loginPage.enterUserName(email);
        loginPage.enterPassword(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User logs in successfully")
    public void user_logs_in_successfully() {
        homePage.assertAccountButtonVisibility();
    }
}

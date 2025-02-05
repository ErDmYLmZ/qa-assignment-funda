package com.funda.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Locator emailAddressBox;
    private final Locator passwordBox;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.emailAddressBox = page.locator("//input[@id='UserName']");
        this.passwordBox = page.locator("//input[@id='Password']");
        this.loginButton = page.locator("(//button[normalize-space()='Log in'])");
    }

    public void enterUserName(String userName) {
        emailAddressBox.fill(userName);
    }

    public void enterPassword(String password) {
        passwordBox.fill(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}

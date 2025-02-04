package com.funda.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private final Locator inloggenButton;
    private final Locator koopButton;
    private final Locator huurButton;
    private final Locator searchBar;
    private final Locator city;
    private final Locator logo;

    public HomePage(Page page) {
        this.inloggenButton = page.locator("Inloggen");
        this.koopButton = page.locator("//button[normalize-space()='Koop']");
        this.huurButton = page.locator("//button[normalize-space()='Huur']");
        this.searchBar = page.getByTestId("search-box");
        this.city = page.locator("(//li[@data-testid='SearchBox-location-suggestion'])[1]");
        this.logo = page.getByAltText("funda logo");
    }

    public void logIn() {
        inloggenButton.click();
    }
    public void selectKoop() {
        koopButton.click();
    }
    public void selectHuur() {
        huurButton.click();
    }
    public void fillSearchBar(String city) {
        searchBar.type(city);
    }
    public void searchBarIsVisible() {
        searchBar.isVisible();
    }
    public void clickCity() {
        city.click();
    }
    public void verifyLogo() {
        logo.isVisible();
    }
}


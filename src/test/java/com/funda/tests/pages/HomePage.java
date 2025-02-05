package com.funda.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    private final Page page;
    private final Locator acceptButton;
    private final Locator inloggenButton;
    private final Locator koopButton;
    private final Locator huurButton;
    private final Locator searchBar;
    private final Locator city;
    private final Locator logo;
    private final Locator accountButton;
    private final Locator zoekEenNvmMakelaarButton;
    private final Locator zoekOpKaartButton;

    public HomePage(Page page) {
        this.page = page;
        this.acceptButton = page.locator("button[id='didomi-notice-agree-button'] span");
        this.inloggenButton = page.locator("//span[@class='pt-1 text-xs md:pt-0 md:text-base']");
        this.accountButton = page.locator("//button[@id='headlessui-menu-button-v-0-34']");
        this.koopButton = page.locator("//button[normalize-space()='Koop']");
        this.huurButton = page.locator("//button[normalize-space()='Huur']");
        this.searchBar = page.getByTestId("search-box");
        this.city = page.locator("(//li[@data-testid='SearchBox-location-suggestion'])[1]");
        this.logo = page.getByAltText("funda logo");
        this.zoekEenNvmMakelaarButton = page.locator("//a[@href='/makelaar-zoeken']");
        this.zoekOpKaartButton = page.locator("//a[normalize-space()='Zoek op kaart']");

    }

    public void acceptButtonClick() {
        acceptButton.waitFor();
        acceptButton.click();
    }

    public void inLoggenButtonClick() {
        inloggenButton.click();
    }

    public void assertAccountButtonVisibility() {
        assertTrue(accountButton.isVisible());
        assertEquals("Account", accountButton.textContent());
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
        assertTrue(searchBar.isVisible());
    }

    public void CityClick() {
        city.click();
    }

    public void verifyLogo() {
        assertTrue(logo.isVisible());
    }

    public void zoekEenNvmMakelaarButtonClick() {
        zoekEenNvmMakelaarButton.click();
    }

    public void zoekOpKaartButtonClick() {
        zoekOpKaartButton.click();
    }
}


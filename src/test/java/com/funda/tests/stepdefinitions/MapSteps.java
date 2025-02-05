package com.funda.tests.stepdefinitions;

import com.funda.tests.pages.HomePage;
import com.funda.tests.pages.MapDisplayPage;
import com.funda.tests.test_base.TestBase;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class MapSteps extends TestBase {
    @Before
    public void initPageObjects() {
        if (homePage == null) homePage = new HomePage(page);
        if (mapDisplayPage == null) mapDisplayPage = new MapDisplayPage(page);
    }

    @When("User clicks the {string} button")
    public void user_clicks_the_search_on_map_button(String string) {
        homePage.zoekOpKaartButtonClick();
        page.waitForLoadState(LoadState.LOAD);

    }
    @Then("The map is displayed")
    public void the_map_is_displayed() {
        mapDisplayPage.isMmapVisible();


    }
}

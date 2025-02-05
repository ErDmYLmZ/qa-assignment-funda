package com.funda.tests.stepdefinitions;

import com.funda.tests.pages.HomePage;
import com.funda.tests.pages.SearchResultPage;
import com.funda.tests.test_base.TestBase;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSteps extends TestBase {
    @Before
    public void initPageObjects() {
        if (homePage == null) homePage = new HomePage(page);
        if (searchResultPage == null) searchResultPage = new SearchResultPage(page);
    }
    @Given("User opens the Funda homepage")
    public void user_opens_the_funda_homepage() {
        page.navigate(dotenv.get("URL"));
        page.locator("button[id='didomi-notice-agree-button'] span").click();
        page.waitForLoadState(LoadState.LOAD);
        assertEquals("Zoek huizen en appartementen te koop / huur in Nederland [funda]", page.title());

    }
    @Then("The Funda logo is displayed")
    public void the_funda_logo_is_displayed() {
        homePage.verifyLogo();
    }
    @Then("The search bar is present")
    public void the_search_bar_is_present() {
        homePage.searchBarIsVisible();
    }
    @When("User selects {string} as a search type for buying")
    public void user_selects_as_a_search_type(String koop) {
        homePage.selectKoop();
    }
    @When("User enters {string} in the search bar and starts searching")
    public void user_enters_in_the_search_bar(String city) {
        page.waitForLoadState();
        homePage.fillSearchBar(city);
        homePage.CityClick();
    }
    @Then("Search results page for {string} is displayed")
    public void search_results_page_for_buying_is_displayed(String city) {
       searchResultPage.assertCitySearchResult(city);
    }

    @When("User selects {string} as a search type for renting")
    public void user_selects_rent_as_a_search_type(String string) {
        homePage.selectHuur();
    }

}

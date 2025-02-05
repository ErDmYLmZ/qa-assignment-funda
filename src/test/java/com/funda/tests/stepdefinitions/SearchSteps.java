package com.funda.tests.stepdefinitions;

import com.funda.tests.pages.HomePage;
import com.funda.tests.pages.SearchResultPage;
import com.funda.tests.test_base.TestBase;
import com.funda.tests.utils.ConfigurationReader;
import com.funda.tests.utils.CsvReader;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchSteps extends TestBase {
    private static Map<String, String> testDataMap = new HashMap<>();

    @Before
    public void initPageObjects() {
        if (homePage == null) homePage = new HomePage(page);
        if (searchResultPage == null) searchResultPage = new SearchResultPage(page);
        loadTestData();
    }

    private void loadTestData() {
        String citySearchDataCsvPath = ConfigurationReader.get("citySearchDataCsvPath");
        List<String[]> cityName = CsvReader.readCsvData(citySearchDataCsvPath);
        if (cityName.isEmpty()) {
            throw new IllegalStateException("CSV file is empty or incorrect");
        }
        for (int i = 0; i < cityName.size(); i++) {
            testDataMap.put("city"+ i, cityName.get(i)[0]);
        }
    }

    @Given("User opens the Funda homepage")
    public void user_opens_the_funda_homepage() {
        page.navigate(ConfigurationReader.get("baseUrl"));
        page.waitForLoadState(LoadState.LOAD);
        homePage.acceptButtonClick();
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertEquals(ConfigurationReader.get("homePageTitle"),page.title(),"Page title does not match!");

    }
    @Then("The Funda logo is displayed")
    public void the_funda_logo_is_displayed() {
        homePage.verifyLogo();
    }
    @Then("The search bar is present")
    public void the_search_bar_is_present() {
        homePage.searchBarIsVisible();
    }
    @When("User selects Koop as a search type for buying")
    public void user_selects_as_a_search_type() {
        homePage.selectKoop();
    }
    @When("User enters {string} in the search bar and starts searching")
    public void user_enters_in_the_search_bar(String cityPlaceholder) {
        String city = testDataMap.get(cityPlaceholder);
        if (city == null) {
            throw new IllegalArgumentException("No available test data for : " + cityPlaceholder);
        }
        homePage.fillSearchBar(city);
        homePage.CityClick();
    }
    @Then("Search results page for {string} is displayed")
    public void search_results_page_for_buying_is_displayed(String cityPlaceholder) {
        String city = testDataMap.get(cityPlaceholder);
        if (city == null) {
            throw new IllegalArgumentException("No available test data for : " + cityPlaceholder);
        }
       searchResultPage.assertCitySearchResult(city);
    }

    @When("User selects Huur as a search type for renting")
    public void user_selects_rent_as_a_search_type() {
        homePage.selectHuur();
    }

}

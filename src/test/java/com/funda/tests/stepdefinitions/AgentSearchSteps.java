package com.funda.tests.stepdefinitions;

import com.funda.tests.pages.AgentSearchPage;
import com.funda.tests.pages.HomePage;
import com.funda.tests.test_base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class AgentSearchSteps extends TestBase {
    @Before
    public void initPageObjects() {
        if (homePage == null) homePage = new HomePage(page);
        if (agentSearchPage == null) agentSearchPage = new AgentSearchPage(page);
    }

    @When("User clicks on the Zoek_een_NVM_makelaar button")
    public void user_clicks_on_the_button() {
        homePage.zoekEenNvmMakelaarButtonClick();
    }
    @Then("The agent search page is displayed")
    public void the_agent_search_page_is_displayed() {
        agentSearchPage.assertAgentSearchPageHeader();
        agentSearchPage.assertAgentSearchPageBoardIsVisible();
        agentSearchPage.assertAgentSearchPageTitle();
    }


}

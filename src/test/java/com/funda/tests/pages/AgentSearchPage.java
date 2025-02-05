package com.funda.tests.pages;

import com.funda.tests.utils.ConfigurationReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgentSearchPage {
    private final Page page;
    private final Locator agentSearchPageHeader;
    private final Locator agentSearchPageBoard;

    public AgentSearchPage(Page page) {
        this.page = page;
        this.agentSearchPageHeader = page.locator("//h1[normalize-space()='Vind een NVM-makelaar die je verder helpt']");
        this.agentSearchPageBoard = page.getByTestId("wizard-step-one");
    }

    public void assertAgentSearchPageHeader() {
        assertEquals(ConfigurationReader.get("agentSearchPageHeader"),agentSearchPageHeader.textContent().trim());
    }

    public void assertAgentSearchPageBoardIsVisible() {
        assertTrue(agentSearchPageBoard.isVisible());
    }

    public void assertAgentSearchPageTitle() {
        assertEquals(ConfigurationReader.get("agentSearchPageTitle"),page.title());
    }
}

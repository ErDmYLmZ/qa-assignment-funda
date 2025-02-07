package com.funda.tests.test_base;

import com.funda.tests.pages.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;



public class TestBase {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;
    protected static BrowserContext context;


    protected HomePage homePage;
    protected SearchResultPage searchResultPage;
    protected LoginPage loginPage;
    protected MapDisplayPage mapDisplayPage;
    protected AgentSearchPage agentSearchPage;
}

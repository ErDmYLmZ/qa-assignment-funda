package com.funda.tests.pages;

import com.funda.tests.test_base.TestBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.Assert;

public class SearchResultPage extends TestBase {
    private final Locator resultHeader;


    public SearchResultPage(Page page) {
        this.resultHeader = page.getByTestId("pageHeader");
    }

    public void assertCitySearchResult(String city) {
        Assert.assertTrue("ERROR: Result does not match the search parameter",resultHeader.textContent().contains(city));
        String searchResultAmount = resultHeader.textContent();
        int result = Integer.parseInt(searchResultAmount.split(" ")[0].replace(".",""));
        Assert.assertTrue("Please check the city for searching",result >= 0);
    }
}

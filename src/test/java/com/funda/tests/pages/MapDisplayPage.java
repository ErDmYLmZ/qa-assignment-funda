package com.funda.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapDisplayPage {
    private final Page page;
    private final Locator mapElement;

    public MapDisplayPage(Page page) {
        this.page = page;
        this.mapElement = page.locator("div.vue-map-container");
    }

    public void isMmapVisible() {
        page.waitForLoadState(LoadState.LOAD);
        assertTrue(mapElement.isVisible());
        System.out.println("mapElement.isVisible() = " + mapElement.isVisible());
    }
}


package com.funda.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapDisplayPage {
    private final Page page;
    private final Locator mapElement;

    public MapDisplayPage(Page page) {
        this.page = page;
        this.mapElement = page.locator("div.vue-map-container");
    }

    public void isMmapVisible() {
        mapElement.waitFor();
        assertTrue(mapElement.isVisible());
    }
}


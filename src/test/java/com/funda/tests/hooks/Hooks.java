package com.funda.tests.hooks;

import com.funda.tests.test_base.TestBase;
import com.funda.tests.utils.DotEnvToSystemEnv;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Paths;

@Slf4j
public class Hooks extends TestBase {

    @Before()
    public void setup() {
        DotEnvToSystemEnv.loadEnvToSystem();
        String browserType = System.getProperty("browser", "chromium");

        TestBase.playwright = Playwright.create();

        switch (browserType.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
                        .setSlowMo(100));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(100));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(100));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
        context = browser.newContext(new Browser.NewContextOptions().setUserAgent(DotEnvToSystemEnv.getEnvValue("USER_AGENT")));
        page = context.newPage();
        log.info("Browser '{}' started", browserType);

    }

    @After()
    public void teardown() {
        if (page != null) {
            page.close();
            log.info("Page closed");
        }
        if (browser != null) {
            browser.close();
            log.info("Browser closed");
        }
        if (playwright != null) {
            playwright.close();
            log.info("Playwright closed");
        }
    }

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                String screenshotName = "target/test-reports/screenshots/" + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".png";

                page.screenshot(new Page.ScreenshotOptions()
                        .setPath(Paths.get(screenshotName))
                        .setFullPage(true));

                log.info("{} is saved", screenshotName);
            } catch (Exception e) {
                log.error("Failed to capture screenshot: {} ", e.getMessage());
            }
        }
    }
}

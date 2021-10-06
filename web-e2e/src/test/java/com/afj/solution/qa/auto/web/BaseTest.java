package com.afj.solution.qa.auto.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.WithAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.afj.solution.qa.auto.web.utils.WebdriverFactory;

import static com.afj.solution.qa.auto.web.utils.AppProperties.BROWSER;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

/**
 * @author Tomash Gombosh
 */
@Slf4j
public class BaseTest implements WithAssertions {

    @BeforeTest
    public void setupListeners() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().includeSelenideSteps(true).screenshots(true).savePageSource(false));
    }

    @BeforeClass
    public void initDriver() {
        log.info("Start web driver {}", BROWSER);
        WebdriverFactory.getInstance().initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanData() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        //getWebDriver().quit();
    }
}

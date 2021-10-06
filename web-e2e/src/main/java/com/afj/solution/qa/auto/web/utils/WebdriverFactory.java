package com.afj.solution.qa.auto.web.utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory.*;

import com.afj.solution.qa.auto.web.utils.drivers.ChromeDriverProvider;
import com.afj.solution.qa.auto.web.utils.drivers.EdgeDriverProvider;
import com.afj.solution.qa.auto.web.utils.drivers.FirefoxDriverProvider;
import com.afj.solution.qa.auto.web.utils.drivers.IeDriverProvider;
import com.afj.solution.qa.auto.web.utils.drivers.SafariDriverProvider;

import static com.afj.solution.qa.auto.web.utils.AppProperties.BROWSER;
import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.EDGE;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Browsers.IE;
import static com.codeborne.selenide.Browsers.SAFARI;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public final class WebdriverFactory {

    private static final String TARGET_BUILD_DOWNLOADS = "target/build/downloads";
    private static final String TARGET_BUILD_REPORTS_TESTS = "target/build/reports/tests";

    private static ThreadLocal<WebdriverFactory> threadLocal;

    private WebdriverFactory() {
    }

    public static WebdriverFactory getInstance() {
        if (threadLocal == null) {
            threadLocal = ThreadLocal.withInitial(WebdriverFactory::new);
        }
        return threadLocal.get();
    }

    public void initDriver() {
        Configuration.screenshots = true;
        Configuration.timeout = 30;
        Configuration.fastSetValue = false;
        Configuration.startMaximized = true;
        Configuration.downloadsFolder = TARGET_BUILD_DOWNLOADS;
        Configuration.reportsFolder = TARGET_BUILD_REPORTS_TESTS;
        getDriver();
    }

    private void getDriver() {
        switch (BROWSER) {
            case CHROME:
                Configuration.browser = ChromeDriverProvider.class.getName();
                break;
            case FIREFOX:
                Configuration.browser = FirefoxDriverProvider.class.getName();
                break;
            case IE:
                Configuration.browser = IeDriverProvider.class.getName();
                break;
            case EDGE:
                Configuration.browser = EdgeDriverProvider.class.getName();
                break;
            case SAFARI:
                Configuration.browser = SafariDriverProvider.class.getName();
                break;
            default:
                throw new WebDriverException("Non correct browser name!");
        }
    }
}

package com.afj.solution.qa.auto.web.utils.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS;

/**
 * @author Tomash Gombosh
 */
public class SafariDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(final DesiredCapabilities desiredCapabilities) {
        final SafariOptions options = new SafariOptions();
        options.setCapability("safari.cleanSession", true);
        options.setCapability(ACCEPT_SSL_CERTS, true);
        return new SafariDriver(options);
    }
}

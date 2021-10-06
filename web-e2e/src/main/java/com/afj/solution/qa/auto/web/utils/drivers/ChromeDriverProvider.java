package com.afj.solution.qa.auto.web.utils.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.afj.solution.qa.auto.web.utils.AppProperties.HEADLESS;
import static org.openqa.selenium.UnexpectedAlertBehaviour.IGNORE;
import static org.openqa.selenium.remote.CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class ChromeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@NonNull final DesiredCapabilities desiredCapabilities) {
        WebDriverManager.chromedriver().setup();
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.setHeadless(Boolean.getBoolean(HEADLESS));
        options.setCapability(UNEXPECTED_ALERT_BEHAVIOUR, IGNORE);
        options.merge(DesiredCapabilities.chrome());
        return new ChromeDriver(options);
    }
}

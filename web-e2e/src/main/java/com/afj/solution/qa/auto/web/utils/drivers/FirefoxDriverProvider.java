package com.afj.solution.qa.auto.web.utils.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.afj.solution.qa.auto.web.utils.AppProperties.HEADLESS;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class FirefoxDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@NonNull final DesiredCapabilities desiredCapabilities) {
        WebDriverManager.firefoxdriver().setup();
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(Boolean.getBoolean(HEADLESS));
        return new FirefoxDriver(firefoxOptions);
    }
}

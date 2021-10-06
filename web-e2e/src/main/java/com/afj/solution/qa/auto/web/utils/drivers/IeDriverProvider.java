package com.afj.solution.qa.auto.web.utils.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class IeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@NonNull final DesiredCapabilities desiredCapabilities) {
        WebDriverManager.iedriver().setup();
        final InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
        ieOptions.setCapability("ignoreProtectedModeSettings", true);
        ieOptions.ignoreZoomSettings();
        ieOptions.destructivelyEnsureCleanSession();
        return new InternetExplorerDriver(ieOptions);
    }
}

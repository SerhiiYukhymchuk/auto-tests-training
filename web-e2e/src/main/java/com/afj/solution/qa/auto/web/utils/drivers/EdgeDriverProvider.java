package com.afj.solution.qa.auto.web.utils.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class EdgeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@NonNull final DesiredCapabilities desiredCapabilities) {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}

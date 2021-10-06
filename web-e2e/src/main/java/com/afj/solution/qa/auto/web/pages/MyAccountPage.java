package com.afj.solution.qa.auto.web.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage {
    private String validEmailMark = "rgb(72, 177, 81)";
    private String invalidEmailMark = "rgba(241, 51, 64, 1)";

    //Web elements (Your personal information)

    private By title = By.cssSelector("a.account>span");
    private By successBannerMessage = By.cssSelector("p.alert.alert-success");

    //Waiter methods
    public void waitForCreateAccountForm(String firstName, String lastName){
        $(successBannerMessage).waitUntil(visible, 4000);
        $(successBannerMessage).shouldHave(cssValue("border-color", validEmailMark));
        $(title).shouldHave(text(firstName + " "+ lastName));
    }

    //Validation methods
    public boolean isAccountCreated(){
        return $(successBannerMessage).isDisplayed();
    }
}

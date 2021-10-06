package com.afj.solution.qa.auto.web.pages;

import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    //Web elements
    private By signInButton = By.cssSelector("a.login");

    //Waiter methods
    public void waitForSignInButton(){
        $(signInButton).shouldBe(enabled);
    }

    //Web elements action methods
    public void clickSignIn(){
        $(signInButton).click();
    }

    //Validation methods
    public boolean validationSignInButtonIsDisplayed(){
        return $(signInButton).isDisplayed();
    }

}

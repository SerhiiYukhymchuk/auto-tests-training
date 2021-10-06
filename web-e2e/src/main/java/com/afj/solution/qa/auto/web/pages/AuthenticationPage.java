package com.afj.solution.qa.auto.web.pages;

import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class AuthenticationPage {
    private String validEmailMark = "rgba(53, 179, 63, 1)";
    private String invalidEmailMark = "rgba(241, 51, 64, 1)";

    //Web elements
    private By createAccountEmailAddressField = By.cssSelector("input#email_create");
    private By createAccountEmailButton = By.cssSelector("button[name='SubmitCreate']");


    //Waiter methods
    public void waitForCreateAccountForm(){
        $(createAccountEmailAddressField).waitUntil(visible, 2000);
        $(createAccountEmailButton).shouldBe(enabled);
    }

    //Web elements action methods
    public void fillCreateAccountEmailAddressField(String email){
        $(createAccountEmailAddressField).setValue(email);
        $(createAccountEmailAddressField).shouldHave(value(email));

    }
    public void clickCreateAccountEmailButton(){
        $(createAccountEmailButton).click();
    }

    //Validation methods
    public boolean validationOfEmail(String validOrInvalid){
        switch (validOrInvalid){
            case "valid":
                return $(createAccountEmailAddressField).has(cssValue("color", validEmailMark));
            case "invalid":
                return $(createAccountEmailAddressField).has(cssValue("color", invalidEmailMark));
            default:
                return $(createAccountEmailAddressField).has(cssValue("color", "rgba(156, 155, 155, 1)"));
        }
    }

    public boolean isFieldFilled(By field, String value){
        return $(field).has(value(value));
    }

    //Getters
    public By getCreateAccountEmailAddressField(){
        return createAccountEmailAddressField;
    }
}

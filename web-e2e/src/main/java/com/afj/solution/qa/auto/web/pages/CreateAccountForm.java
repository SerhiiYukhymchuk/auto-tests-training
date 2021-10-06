package com.afj.solution.qa.auto.web.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateAccountForm {
    private String validEmailMark = "rgba(53, 179, 63, 1)";
    private String invalidEmailMark = "rgba(241, 51, 64, 1)";

    //Web elements (Your personal information)
    private By genderMaleRadioButton = By.cssSelector("input#id_gender1");
    private By genderFemaleRadioButton = By.cssSelector("input#id_gender2");
    private By firstNameField = By.cssSelector("input#customer_firstname");
    private By lastNameField = By.cssSelector("input#customer_lastname");
    private By emailField = By.cssSelector("input#email");
    private By passwordField = By.cssSelector("input#passwd");
    private By birthDayDDL = By.cssSelector("select#days");
    private By birthMonthDDL = By.cssSelector("select#months");
    private By birthYearDDL = By.cssSelector("select#years");

    //Web elements (Your address)
    private By firstNameAddressField = By.cssSelector("input#firstname");
    private By lastNameAddressField = By.cssSelector("input#lastname");
    private By addressField = By.cssSelector("input#address1");
    private By cityField = By.cssSelector("input#city");
    private By stateField = By.cssSelector("select#id_state");
    private By zipCodeField = By.cssSelector("input#postcode");
    private By countryField = By.cssSelector("select#id_country");
    private By mobilePhoneField = By.cssSelector("input#phone_mobile");
    private By assignAnAddressAliasForFutureReferenceField = By.cssSelector("input#alias");

    //Web elements (Buttons)
    private By registerButton = By.cssSelector("button#submitAccount");


    //Waiter methods
    public void waitForCreateAccountForm(String email){
        $(registerButton).waitUntil(exist, 20000);
        $(emailField).shouldHave(value(email));
    }

    //Web elements action methods
    public void fillCreateAccountForm(By field, String value){
        $(field).setValue(value);
        $(field).shouldHave(value(value));
    }

    public void clickRegisterButton(){
        $(registerButton).click();
    }

    public void selectGender(int oneOrTwo){
        if(oneOrTwo == 1){
            $(genderMaleRadioButton).click();
        }
        else {
            $(genderFemaleRadioButton).click();
        }
    }

    //Validation methods
    public boolean validationOfField(By field, String validOrInvalid){
        switch (validOrInvalid){
            case "valid":
                return $(field).has(cssValue("color", validEmailMark));
            case "invalid":
                return $(field).has(cssValue("color", invalidEmailMark));
            default:
                return $(field).has(cssValue("color", "rgba(156, 155, 155, 1)"));
        }
    }

    public boolean isFieldFilled(By field, String value){
        return $(field).has(value(value));
    }

    //Getters
    public By getFirstNameField(){
        return firstNameField;
    }
    public By getLastNameField(){
        return lastNameField;
    }
    public By getEmailField(){
        return emailField;
    }
    public By getPasswordField(){
        return passwordField;
    }
}
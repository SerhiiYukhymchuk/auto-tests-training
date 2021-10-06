package com.afj.solution.qa.auto.web.test;

import com.afj.solution.qa.auto.web.BaseTest;
import com.afj.solution.qa.auto.web.ConfProperties;
import com.afj.solution.qa.auto.web.pages.AuthenticationPage;
import com.afj.solution.qa.auto.web.pages.CreateAccountForm;
import com.afj.solution.qa.auto.web.pages.MainPage;
import com.afj.solution.qa.auto.web.pages.MyAccountPage;
import org.testng.annotations.Test;
import java.util.UUID;

import static com.codeborne.selenide.Selenide.open;

public class CreateAccountWithValidData extends BaseTest {
    UUID uuid = UUID.randomUUID();
    //Pages
    MainPage mainPage = new MainPage();
    AuthenticationPage authenticationPage = new AuthenticationPage();
    CreateAccountForm createAccountForm = new CreateAccountForm();
    MyAccountPage myAccountPage = new MyAccountPage();

    //URL of main page
    String url = ConfProperties.getProperties("mainPageUrl");

    //Valid data for filling out form
    String email = uuid.toString() + "@vvvv.com";
    String firstName = ConfProperties.getProperties("validFirstName");
    String lastName =  ConfProperties.getProperties("validLastName");
    String password =  ConfProperties.getProperties("validPassword");

    @Test(description = "Creation of account using valid mandatory data")
    public void CreateAccountWithValidData(){
        open(url);
        mainPage.waitForSignInButton();
        assertThat(mainPage.validationSignInButtonIsDisplayed()).isTrue();
        mainPage.clickSignIn();

        authenticationPage.waitForCreateAccountForm();
        authenticationPage.fillCreateAccountEmailAddressField(email);
        assertThat(authenticationPage.isFieldFilled(authenticationPage.getCreateAccountEmailAddressField(), email)).isTrue();
        authenticationPage.clickCreateAccountEmailButton();
        assertThat(authenticationPage.validationOfEmail("valid")).isTrue();

        createAccountForm.waitForCreateAccountForm(email);
        assertThat(createAccountForm.isFieldFilled(createAccountForm.getEmailField(), email)).isTrue();
        createAccountForm.fillCreateAccountForm(createAccountForm.getFirstNameField(), firstName);
        assertThat(createAccountForm.isFieldFilled(createAccountForm.getFirstNameField(), firstName)).isTrue();
        createAccountForm.fillCreateAccountForm(createAccountForm.getLastNameField(), lastName);
        assertThat(createAccountForm.isFieldFilled(createAccountForm.getLastNameField(), lastName)).isTrue();
        createAccountForm.fillCreateAccountForm(createAccountForm.getPasswordField(), password);
        createAccountForm.selectGender(1);
        assertThat(createAccountForm.validationOfField(createAccountForm.getLastNameField(), "valid")).isTrue();
        assertThat(createAccountForm.validationOfField(createAccountForm.getPasswordField(), "valid")).isTrue();
        createAccountForm.clickRegisterButton();

        myAccountPage.waitForCreateAccountForm(firstName, lastName);
        assertThat(myAccountPage.isAccountCreated()).isTrue();
    }
}

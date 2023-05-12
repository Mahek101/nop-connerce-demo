package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    HomePage homePage; // Declaring HomePage Object
    RegisterPage registerPage; // Declaring RegisterPage Object

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"Sanity", "Regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickingOnRegisterLink(); // Clicking on register link
        registerPage.isRegisterTextDisplayed(); // Verifying register text is displayed or not
    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickingOnRegisterLink(); // Clicking on register link
        registerPage.clickingOnRegisterButton(); // Clicking on register button
        registerPage.isFirstNameRequiredTextDisplayed(); // Verifying first name error text
        registerPage.isLastNameRequiredTextDisplayed(); // Verifying last name error text
        registerPage.isEmailRequiredTextDisplayed(); // Verifying email error text
        registerPage.isPasswordRequiredTextDisplayed(); // Verifying password error text
        registerPage.isConfirmedPasswordRequiredTextDisplayed(); // Verifying confirm password error text
    }

    @Test(groups = "Regression")
    public void VerifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickingOnRegisterLink(); // Clicking on register link
        registerPage.selectingFemaleRadioButton(); // Selecting female radio button
        registerPage.enteringFirstNameInToFirstNameField("Sneha"); // Entering first name
        registerPage.enteringLastNameInToLastNameField("Mehta"); // Entering last name
        registerPage.selectingDayOfBirthFromDropDown("10"); // Selecting day of birth
        registerPage.selectingMonthOfBirthFromDropDown("November"); // Selecting month of birth
        registerPage.selectingYearOfBirthFromDropDown("1982"); // Selecting year of birth
        registerPage.enteringEmailToEmailField("shehamehta123@gmail.com"); // Entering email
        registerPage.enteringPasswordToPasswordField("Sneha12345"); // Entering password
        registerPage.enteringPasswordToConfirmPasswordField("Sneha12345"); // Entering confirmed password
        registerPage.clickingOnRegisterButton(); // Clicking on register button
        registerPage.isYourRegistrationCompleteTextDisplayed(); // Verifying registration complete text
        registerPage.clickingOnContinueButton(); // Clicking on continue button
    }
}

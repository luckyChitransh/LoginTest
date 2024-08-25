package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.BrowserActions;
import com.pages.HomePage;
import com.pages.LoginPage;

@Listeners(com.utility.Listeners.class)

public class LoginTests extends BrowserActions {
	BrowserActions browserActions = new BrowserActions();
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void navigateToURL() throws Exception {
		browserActions.openBrowser();
		browserActions.hitURL();
	}

	@AfterMethod
	public void closeBrowser() {
		browserActions.closeBrowser();
		;
	}

	@Test(priority = 1, retryAnalyzer = com.utility.RetryAnalyzer.class)
	public void validateSuccessfulLogin() {
		loginPage.enterUserName(validUsername);
		loginPage.enterPassword(validPassword);
		loginPage.clickSubmit();

		softAssert.assertEquals(homePage.successMessage(), "Logged In Successfully");
		softAssert.assertAll();
	}

	@Test(priority = 2, retryAnalyzer = com.utility.RetryAnalyzer.class)
	public void validateInvalidPassword() {
		loginPage.enterUserName(validUsername);
		loginPage.enterPassword(invalidPassword1);
		loginPage.clickSubmit();

		softAssert.assertEquals(loginPage.errorMessage(), "Your password is invalid!");
		softAssert.assertAll();
	}

	@Test(priority = 3, retryAnalyzer = com.utility.RetryAnalyzer.class)
	public void validateInvalidUsername() {
		loginPage.enterUserName(invalidUsername2);
		loginPage.enterPassword(validPassword);
		loginPage.clickSubmit();

		softAssert.assertEquals(loginPage.errorMessage(), "Your username is invalid!");
		softAssert.assertAll();
	}

	@Test(priority = 4, retryAnalyzer = com.utility.RetryAnalyzer.class)
	public void validateInvalidCredentials() {
		loginPage.enterUserName(invalidUsername2);
		loginPage.enterPassword(invalidPassword2);
		loginPage.clickSubmit();

		softAssert.assertEquals(loginPage.errorMessage(), "Your username is invalid!");
		softAssert.assertAll();
	}

	@Test(priority = 5, retryAnalyzer = com.utility.RetryAnalyzer.class)
	public void validateBlankInput() {

		loginPage.clickSubmit();

		softAssert.assertEquals(loginPage.errorMessage(), "Your username is invalid!");
		softAssert.assertAll();
	}

	@Test(priority = 6, retryAnalyzer = com.utility.RetryAnalyzer.class)
	public void validateFailedScenario() {

		loginPage.clickSubmit();

		softAssert.assertEquals(loginPage.errorMessage(), "Failed: Your username is invalid!");
		softAssert.assertAll();
	}

}

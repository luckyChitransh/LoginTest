package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BrowserActions {
	
	private static Logger log = LogManager.getLogger(LoginPage.class.getName());
	
	public void enterUserName(String userName) {
		WebElement userNameField = driver.findElement(By.id("username"));
		userNameField.sendKeys(userName);
		log.info("Entered Username");

	}

	public void enterPassword(String password) {
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(password);
		log.info("Entered Password");
	}

	public void clickSubmit() {
		WebElement submitButton = driver.findElement(By.id("submit"));
		submitButton.click();
		log.info("Clicked on Submit button.");

	}

	public String errorMessage() {
		waitTillVisibility("error");
		WebElement errorMessage = driver.findElement(By.id("error"));
		log.info("Error message Captured.");
		return errorMessage.getText();
	}
}

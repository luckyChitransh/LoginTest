package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.Property;

public class BrowserActions extends Property {
	public static WebDriver driver;

	private static Logger log = LogManager.getLogger(BrowserActions.class.getName());

	public void openBrowser() throws Exception {
		driver = new ChromeDriver();
		log.info("Browser initialized");
		driver.manage().window().maximize();
		log.info("Browser maximized");
		readDataFromTextFile();
	}

	public void hitURL() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		log.info("Navigated to URL");
	}

	public void closeBrowser() {
		driver.quit();
		log.info("Browser Closed");
	}

	public void waitTillVisibility(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		log.info("waiting for the visibility of the element");
	}

}

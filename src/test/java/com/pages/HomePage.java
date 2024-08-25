package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BrowserActions
{
	private static Logger log = LogManager.getLogger(HomePage.class.getName());	
	
	public  String successMessage()
	{
		WebElement successMessage = driver.findElement(By.className("post-header"));
		log.info("Success message captured.");
		return successMessage.getText();
	}
	
}

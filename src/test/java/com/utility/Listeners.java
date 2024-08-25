package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.pages.BrowserActions;

public class Listeners extends BrowserActions implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("The test " + result.getName() + " is running.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("The test " + result.getName() + " is passed");
		Reporter.log("The test " + result.getName() + " is passed");

		System.setProperty("org.uncommons.reportng.logOutputReport", "true");
		System.setProperty("org.uncommons.reportng.title", "Automated tests results");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("The test " + result.getName() + " is failed.");
		Reporter.log("The test " + result.getName() + " is falied");
		System.setProperty("org.uncommons.reportng.logOutputReport", "true");
		System.setProperty("org.uncommons.reportng.title", "Automated tests results");

		Random random = new Random();
		int num = random.nextInt();

		// taking screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "//Screenshot//" + "image" + num + ".png";
		try {
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Reporter.log("<a title = 'Automation Test' href = " + dest + ">Screenshot</a>");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("The test " + result.getName() + " is skipped");
		System.setProperty("org.uncommons.reportng.logOutputReport", "true");
		System.setProperty("org.uncommons.reportng.title", "Automated tests results");

	}

}
